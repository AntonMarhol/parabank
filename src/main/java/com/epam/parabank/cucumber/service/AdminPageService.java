package com.epam.parabank.cucumber.service;

import com.epam.parabank.ui.pageobject.AdminPage;
import com.epam.parabank.ui.pageobject.MainPage;

public class AdminPageService {

    private AdminPage adminPage;

    public void cleanDatabase() {
        adminPage.cleanDatabase();
    }

    public void openAdminPage() {
        this.adminPage = new MainPage().openAdminPage();
    }


    public String getDatabaseCleanedMessage() {
        return adminPage.getDatabaseCleanedMessage();
    }
}
