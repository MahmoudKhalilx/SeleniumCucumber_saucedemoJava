package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class P03_CartPage extends P00_BasePage {

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

//    @FindBy(xpath = "//div[@class='inventory_item_name']")
//    private List<WebElement> inventory_item_name;


    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public P03_CartPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("/cart.html");
    }

    public int getNumberOfCartItems() {
        return cartItems.size();

    }



    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}