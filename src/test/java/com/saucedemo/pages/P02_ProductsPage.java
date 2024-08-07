package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class P02_ProductsPage extends P00_BasePage {

    @FindBy(xpath = "(//div[@class='inventory_item'])")
    private List<WebElement> productItems;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    public P02_ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }

    public void addMostExpensiveProducts(int count) {
        productItems.stream()
                .sorted((a, b) -> getPrice(b).compareTo(getPrice(a)))
                .limit(count)
                .forEach(this::addToCart);
    }

    private Double getPrice(WebElement product) {
        String priceText = product.findElement(By.className("inventory_item_price")).getText();
        return Double.parseDouble(priceText.replace("$", ""));
    }

    private void addToCart(WebElement product) {
        product.findElement(By.cssSelector("button[id^='add-to-cart']")).click();
    }

    public void clickCartButton() {
        cartButton.click();
    }






}