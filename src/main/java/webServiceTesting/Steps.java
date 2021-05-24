package webServiceTesting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Steps {

  CreateUser createUser;
  String name, job, registerBody;
  RequestSpecification deleteRequest;

  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    createUser = new CreateUser();
  }

  @When("^I set name \"([^\"]*)\"$")
  public void setName(String name) {
    createUser.setName(name);
    this.name = name;
  }

  @When("^I set job \"([^\"]*)\"$")
  public void setJob(String job) {
    createUser.setName(job);
    this.job = job;
  }

  @Then("^I validate my POST response is correct$")
  public void validateMyPostResponseIsCorrect() {
    Response response = createUser.getRequestSpecification().body(createUser.buildBody()).post();
    Assert.assertEquals(201, response.statusCode());

  }

  @Given("^I set user for deletion - \"([^\"]*)\"$")
  public void setDeleteRequest(String user) {
    deleteRequest = RestAssured.given()
            .baseUri("https://reqres.in/api/")
            .basePath("/users/" + user);
  }

  @Then("^I validate my DELETE response is correct$")
  public void validateMyDeleteResponseIsCorrect() {
    Response response = deleteRequest.delete();
    response.prettyPrint();
    Assert.assertEquals(204, response.statusCode());

  }

  @Given("^I set email for registration - \"([^\"]*)\"$")
  public void setEmail(String email) {
    registerBody = "{\n" +
            "    \"email\": \"" + email + "\",\n" +
            "}";
  }

  @Then("^I validate my register response is incorrect$")
  public void validateMyRegisterResponseIsIncorrect() {
    Response response = RestAssured.given()
            .body(registerBody)
            .post("https://reqres.in/api/register");
    Assert.assertEquals(400, response.statusCode());

  }
}
