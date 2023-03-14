package com.qaprosoft.carina.demo.gui.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TwitterPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Sauce Labs']")
    private ExtendedWebElement titleLabel;

    public TwitterPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(titleLabel);
    }
}
