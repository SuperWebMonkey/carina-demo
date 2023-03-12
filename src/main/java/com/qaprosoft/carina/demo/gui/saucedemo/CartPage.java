package com.qaprosoft.carina.demo.gui.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='title'][text()='Your Cart']")
    private ExtendedWebElement titleLabel;

    @FindBy(xpath = "//div[@class='inventory_item_name'][text()='%s']")
    private ExtendedWebElement productTitle;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(titleLabel);
    }

    public boolean isProductDisplayed(String productName) {
        return productTitle.format(productName).isElementPresent();
    }
}
