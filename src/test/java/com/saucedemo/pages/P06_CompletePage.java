package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P06_CompletePage extends P00_BasePage {

    @FindBy(css = ".complete-header")
    private WebElement thankYouMessage;

    @FindBy(css = ".complete-text")
    private WebElement dispatchMessage;

    public P06_CompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCompletePage() {
        return driver.getCurrentUrl().contains("/checkout-complete.html");
    }

    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }

    public String getDispatchMessage() {
        return dispatchMessage.getText();
    }
}