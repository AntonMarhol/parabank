package com.epam.parabank.cucumber.service;

import com.epam.parabank.api.service.RestDatabaseService;
import io.restassured.response.Response;
import org.testng.Assert;

public class DatabaseApiService {

    private final RestDatabaseService databaseRestService;
    private Response cleanDatabaseResponse;

    public DatabaseApiService() {
        databaseRestService = new RestDatabaseService();
    }

    public void sendCleanDatabaseRequest() {
        cleanDatabaseResponse = databaseRestService.cleanDatabase();
    }

    public void verifyCleanDatabaseResponse(final int responseCode) {
        Assert.assertEquals(cleanDatabaseResponse.getStatusCode(), responseCode, "Wrong code");
    }
}
