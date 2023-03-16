package com.epam.parabank.cucumber.steps;

import com.epam.parabank.cucumber.service.AccountApiService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountApiSteps {

    private final AccountApiService accountApiService;

    public CreateAccountApiSteps() {
        accountApiService = new AccountApiService();
    }

    @When("I create new {string} account via API")
    public void createNewAccount(final String accountType) {
        accountApiService.createNewAccount(accountType);
    }

    @And("Create account {int} response code is received")
    public void verifyCreateAccountResponse(final int responseCode) {
        accountApiService.verifyResponse(responseCode);
    }

    @Then("New account API credentials are correct")
    public void verifyNewAccountCredentials() {
        accountApiService.verifyCreatedAccountType();
    }
}
