package rest;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Rest {

  public void restTest() {
    RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5";
    RequestSpecification request = RestAssured.given();

        request
            .given()
            .queryParam("q", "London,UK")
            .queryParam("appid", "c87a9dcd799f348249ad70b802e03639")
            .when()
            .get("/weather").then().log().body();

    request
        .given()
        .queryParam("CUSTOMER_ID", "68195")
        .queryParam("PASSWORD", "1234!")
        .queryParam("Account_No", "1")
        .when()
        .get("http://demo.guru99.com/V4/sinkministatement.php")
        .then()
        .log()
        .body();
//    String jsonString = response.asString();
//    System.out.println(response.getStatusCode());
//    Assert.assertEquals(jsonString.contains("London"), true);
  }

}
