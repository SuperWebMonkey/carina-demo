package com.qaprosoft.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

public class FooterLink {
    @FindBy(xpath = "//*[@id='page_wrapper']/footer")
    private ExtendedWebElement footer;

    @FindBy(xpath ="//*[@id='page_wrapper']/footer/ul/li[1]/a")
    private ExtendedWebElement twitterLink;

    public void clickTwitterLink() {
        twitterLink.click();
    }
}
