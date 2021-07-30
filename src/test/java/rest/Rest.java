package rest;

import com.thoughtworks.gauge.Gauge;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class Rest {

  public void restTest1() {
    RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5";
    RequestSpecification request = RestAssured.given();
    request
        .given()
        .queryParam("q", "London,UK")
        .queryParam("appid", "c87a9dcd799f348249ad70b802e03639")
        .when()
        .get("/weather")
        .then()
        .statusCode(200)
        .body("weather[0].description", Matchers.equalTo("light intensity drizzle"));
    Gauge.writeMessage(
        "este es el primer response \n"
            + request
                .given()
                .queryParam("q", "London,UK")
                .queryParam("appid", "c87a9dcd799f348249ad70b802e03639")
                .when()
                .get("/weather")
                .body()
                .print());
  }

  public void restTest2() {
    RequestSpecification request = RestAssured.given();
    Gauge.writeMessage(
        "Este es el segundo response \n"
            + request
                .given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php")
                .print());
  }

  public void primerEjemploCurso() {
    Gauge.writeMessage(
        RestAssured.given()
            .baseUri("https://api.postman.com")
            .header("x-api-key", "PMAK-61034f79093f73004242fe07-f3506a1ddcb9710efe3cc1fce93c7d39d4")
            .when()
            .get("/workspaces")
            .print());
  }
}
