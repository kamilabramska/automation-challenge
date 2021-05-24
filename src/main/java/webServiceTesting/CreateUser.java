package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

  private String name;
  private String job;
  private final RequestSpecification requestSpecification;

  public CreateUser() {
    this.requestSpecification = RestAssured.given()
            .baseUri("https://reqres.in/api")
            .basePath("/users");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String buildBody() {

    return "{\n" +
            "    \"name\": \"" + this.name + "\",\n" +
            "    \"job\": \"" + this.job + "\"\n" +
            "}";
  }

  public String buildBodyWithSurname() {

    return "{\n" +
            "    \"name\": \"" + this.name + " autoSurname\",\n" +
            "    \"job\": \"" + this.job + "\"\n" +
            "}";
  }
}
