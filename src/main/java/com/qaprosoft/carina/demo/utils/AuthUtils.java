package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.demo.gui.saucedemo.LoginPage;
import com.qaprosoft.carina.demo.gui.saucedemo.ProductPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.testng.Assert;

public class AuthUtils implements ICustomTypePageFactory {
    public ProductPage login(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        return loginPage.clickLoginButton();
    }

    public ProductPage loginStandardUser() {
        return login(R.TESTDATA.get("username_"), R.TESTDATA.get("password"));
    }
}
