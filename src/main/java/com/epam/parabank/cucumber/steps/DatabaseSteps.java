package com.epam.parabank.cucumber.steps;

import com.epam.parabank.cucumber.service.AdminPageService;
import com.epam.parabank.cucumber.service.DatabaseApiService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DatabaseSteps {

    private final DatabaseApiService databaseApiService;
    private final AdminPageService adminPageService;

    public DatabaseSteps() {
        this.databaseApiService = new DatabaseApiService();
        this.adminPageService = new AdminPageService();
    }

    @When("^I send clean database api request$")
    public void databaseIsCleanedApi() {
        databaseApiService.sendCleanDatabaseRequest();
    }

    @Then("Clean database {int} response code is received")
    public void isResponseCodeCorrect(final int responseCode) {
        databaseApiService.verifyCleanDatabaseResponse(responseCode);
    }

    @And("^I open Admin Page$")
    public void openAdminPage() {
        adminPageService.openAdminPage();
    }

    @When("^I clean database on Admin Page$")
    public void cleanDatabaseOnAdminPage() {
        adminPageService.cleanDatabase();
    }

    @And("{string} message is displayed on Admin Page")
    public void getDatabaseCleanedMessage(final String databaseText) {
        Assert.assertEquals(adminPageService.getDatabaseCleanedMessage(), databaseText, "Wrong text!");
    }
}