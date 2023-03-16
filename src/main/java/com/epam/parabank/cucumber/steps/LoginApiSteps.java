package com.epam.parabank.cucumber.steps;

import com.epam.parabank.cucumber.service.LoginApiService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginApiSteps {

    private final LoginApiService loginApiService;

    public LoginApiSteps() {
        loginApiService = new LoginApiService();
    }

    @When("^I login via API$")
    public void loginViaApi() {
        loginApiService.loginUser();
    }

    @Then("Login {int} response code is received")
    public void isResponseCodeCorrect(final int responseCode) {
        loginApiService.verifyLoginResponse(responseCode);
    }

    @Then("Logged in API credentials are correct")
    public void verifyLoggedInCredential() {
        loginApiService.verifyCustomerCredential();
    }
}
