package steps;

import com.thoughtworks.gauge.Step;
import rest.Rest;

public class RestAssuredStep {

  private Rest rest;

  public RestAssuredStep() {
    rest = new Rest();
  }

  @Step("hola mundo Rest-Assured")
  public void holaMundo() {
    rest.restTest1();
  }

  @Step("hola mundo2 Rest-Assured")
  public void holaMundo2() {
    rest.restTest2();
  }

  @Step("primer ejemplo curso")
  public void primerEjemploCurso() {
    rest.primerEjemploCurso();
  }
  @Step("emoji")
  public void holaEmoji(){
    System.out.println("hola");
  }
}
