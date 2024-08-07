package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P05_OverviewPage extends P00_BasePage {

    @FindBy(css = ".summary_subtotal_label")
    private WebElement itemTotalElement;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public P05_OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnOverviewPage() {
        return driver.getCurrentUrl().contains("/checkout-step-two.html");
    }

    public double getItemTotal() {
        String totalText = itemTotalElement.getText().replaceAll("[^0-9.]", "");
        return Double.parseDouble(totalText);
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    @FindBy(css = ".summary_subtotal_label")
    private WebElement subtotalLabel;

    // ... other elements and methods ...

    public String getItemsTotalBeforeTax() {
        return subtotalLabel.getText().split("\\$")[1];
    }
}