package com.qaprosoft.carina.demo.gui.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.saucedemo.components.Footer;
import com.qaprosoft.carina.demo.gui.saucedemo.components.ProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='title'][text()='Products']")
    private ExtendedWebElement titleLabel;

    @FindBy(css = ".shopping_cart_link")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<ProductItem> products;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement menuBtn;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//*[@id='about_sidebar_link']")
    private ExtendedWebElement aboutLink;

    @FindBy(css = ".footer")
    private Footer footerLink;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(titleLabel);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public Footer getFooterLink() {
        return footerLink;
    }

    public void clicklogoutButton() {
        menuBtn.click();
        logoutButton.click();
    }

    public AboutPage clickAboutLink() {
        menuBtn.click();
        aboutLink.click();
        return new AboutPage(driver);
    }

    public List<ProductItem> getProducts() {
        return products;
    }
}
