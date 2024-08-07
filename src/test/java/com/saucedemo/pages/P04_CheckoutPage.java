package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P04_CheckoutPage extends P00_BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public P04_CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCheckoutPage() {
        return driver.getCurrentUrl().contains("/checkout-step-one.html");
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}