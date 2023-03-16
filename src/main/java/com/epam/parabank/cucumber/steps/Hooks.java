package com.epam.parabank.cucumber.steps;

import com.epam.parabank.cucumber.service.DatabaseApiService;
import com.epam.parabank.ui.businessobject.builder.UserManager;
import com.epam.parabank.ui.businessobject.model.User;
import com.epam.parabank.ui.driver.DriverSingleton;
import com.epam.parabank.ui.pageobject.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@registerUser")
    public void registerUser() {
        User user = new UserManager().getUser();
        new MainPage().openRegisterPage().fillRegistrationForm().setUpUser(user);
    }

    @After("@cleanDatabase")
    public void cleanDatabase() {
        new DatabaseApiService().sendCleanDatabaseRequest();
    }

    @After("@closeBrowser")
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }
}
