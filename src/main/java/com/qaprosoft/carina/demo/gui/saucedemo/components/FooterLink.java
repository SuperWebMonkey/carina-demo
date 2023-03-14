package com.qaprosoft.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.saucedemo.TwitterPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterLink extends AbstractUIObject {
    @FindBy(linkText = "Twitter")
    private ExtendedWebElement twitterLink;

    public FooterLink(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public TwitterPage clickTwitterLink() {
        twitterLink.click();
        return new TwitterPage(driver);
    }
}
