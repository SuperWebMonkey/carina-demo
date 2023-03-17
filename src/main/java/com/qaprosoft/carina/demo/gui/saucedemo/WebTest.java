package com.qaprosoft.carina.demo.gui.saucedemo;

import com.qaprosoft.carina.demo.gui.saucedemo.components.ProductItem;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTest extends AbstractSauceDemoTest {
    @Test
    public void testLogin() {
        ProductPage productPage = authUtils.loginStandardUser();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
    }

    @Test
    public void clickOnTwitter() {
        ProductPage productPage = authUtils.loginStandardUser();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
        TwitterPage twitterPage = productPage.getFooterLink().clickTwitterLink();
        Assert.assertTrue(twitterPage.isPageOpened(), "Twitter page is not opened");
    }

    @Test
    public void clickAboutLink() {
        ProductPage productPage = authUtils.loginStandardUser();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
        AboutPage aboutPage = productPage.clickAboutLink();
        Assert.assertTrue(aboutPage.isPageOpened(), "about page is not opened");
    }

    @Test
    public void logout() {
        ProductPage productPage = authUtils.loginStandardUser();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
        productPage.clicklogoutButton();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }

    @Test
    public void addCart() {
        String[] productName = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Onesie"};
        ProductPage productPage = authUtils.loginStandardUser();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");

        List<ProductItem> products = productPage.getProducts();
        for (int i = 0; i < productName.length; i++) {
            for (int j = 0; j  < products.size(); j++) {
                if (productName[i].equals(products.get(j).getProductTitle())) {
                    products.get(j).clickAddToCartButton();
                }
            }
        }

        CartPage cartPage = productPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "cart page is not opened");

        for (int i = 0; i < productName.length; i++) {
            Assert.assertTrue(cartPage.isProductDisplayed(productName[i]), "Product " + productName + " is not displayed");
        }
    }
}
