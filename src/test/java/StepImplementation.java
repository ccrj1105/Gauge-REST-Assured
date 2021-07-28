import static org.assertj.core.api.Assertions.assertThat;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import java.util.HashSet;
import rest.Rest;

public class StepImplementation {

  private HashSet<Character> vowels;
  private Rest rest;

  public StepImplementation() {
    this.rest = new Rest();
  }

  @Step("Vowels in English language are <vowelString>.")
  public void setLanguageVowels(String vowelString) {
    vowels = new HashSet<>();
    for (char ch : vowelString.toCharArray()) {
      vowels.add(ch);
    }
    rest.restTest();
  }

  @Step("The word <word> has <expectedCount> vowels.")
  public void verifyVowelsCountInWord(String word, int expectedCount) {
    int actualCount = countVowels(word);
    assertThat(expectedCount).isEqualTo(actualCount);
  }

  @Step("Almost all words have vowels <wordsTable>")
  public void verifyVowelsCountInMultipleWords(Table wordsTable) {
    for (TableRow row : wordsTable.getTableRows()) {
      String word = row.getCell("Word");
      int expectedCount = Integer.parseInt(row.getCell("Vowel Count"));
      int actualCount = countVowels(word);

      assertThat(expectedCount).isEqualTo(actualCount);
    }
  }

  private int countVowels(String word) {
    int count = 0;
    for (char ch : word.toCharArray()) {
      if (vowels.contains(ch)) {
        count++;
      }
    }
    return count;
  }
}
