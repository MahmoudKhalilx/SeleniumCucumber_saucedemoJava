package com.saucedemo.steps;

import com.saucedemo.pages.*;
import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SauceDemoSteps {

    private WebDriver driver;
    private P01_LoginPage P01_LoginPage;
    private P02_ProductsPage P02_ProductsPage;
    private P03_CartPage P03_CartPage;
    private P04_CheckoutPage P04_CheckoutPage;
    private P05_OverviewPage P05_OverviewPage;
    private P06_CompletePage P06_CompletePage;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
        P01_LoginPage = new P01_LoginPage(driver);
        P02_ProductsPage = new P02_ProductsPage(driver);
        P03_CartPage = new P03_CartPage(driver);
        P04_CheckoutPage = new P04_CheckoutPage(driver);
        P05_OverviewPage = new P05_OverviewPage(driver);
        P06_CompletePage = new P06_CompletePage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }


    //navigate to login page
    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("I enter {string} username {string} and {string} password {string}")
    public void iEnterInvalidUsernameAndPassword(String username_scenario, String username,String password_scenario, String password) {
        P01_LoginPage.enterUsername(username);
        P01_LoginPage.enterPassword(password);
    }
//==========================================================
    @When("I enter valid username {string} and valid password {string}")
    public void iEnterValidUsernameAndValidPassword(String username, String password) {
    P01_LoginPage.enterUsername(username);
    P01_LoginPage.enterPassword(password);
    }

//    @When("I enter username {string} and password {string}")
//    public void iEnterUsernameAndPassword(String username, String password) {
//        P01_LoginPage.enterUsername(username);
//        P01_LoginPage.enterPassword(password);
//    }
    //==========================================================



    @When("I click the login button")
    public void iClickTheLoginButton() {
        P01_LoginPage.clickLoginButton();
    }

    @Then("I should see an error message with error message is {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(P01_LoginPage.getErrorMessage(),expectedErrorMessage, "Error message should be displayed");
    }



    @Then("I should be logged in successfully and navigated to the products page")
    public void iShouldBeLoggedInSuccessfullyAndNavigatedToTheProductsPage() {
        Assert.assertTrue(P02_ProductsPage.isOnProductsPage(), "Should be on products page");
    }






    @When("I add the two most expensive products to my cart")
    public void iAddTheTwoMostExpensiveProductsToMyCart() {
        P02_ProductsPage.addMostExpensiveProducts(2);
    }

    @When("I click on the cart button")
    public void iClickOnTheCartButton() {
        P02_ProductsPage.clickCartButton();
    }

    @Then("I should be navigated to the cart page")
    public void iShouldBeNavigatedToTheCartPage() {
        Assert.assertTrue(P03_CartPage.isOnCartPage(), "Should be on cart page");
    }

    @Then("I should see the previously selected products in the cart")
    public void iShouldSeeThePreviouslySelectedProductsInTheCart() {
        Assert.assertEquals(P03_CartPage.getNumberOfCartItems(), 2, "Should have 2 items in cart");
    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        P03_CartPage.clickCheckoutButton();
    }

    @Then("I should be navigated to the checkout page")
    public void iShouldBeNavigatedToTheCheckoutPage() {
        Assert.assertTrue(P04_CheckoutPage.isOnCheckoutPage(), "Should be on checkout page");
    }






    @When("I fill in the checkout form with:")
    public void iFillInTheCheckoutFormWith(io.cucumber.datatable.DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("First Name");
        String lastName = data.get(0).get("Last Name");
        String postalCode = data.get(0).get("Postal Code");
        P04_CheckoutPage.fillCheckoutForm(firstName, lastName, postalCode);
    }

    @When("I click the continue button")
    public void iClickTheContinueButton() {
        P04_CheckoutPage.clickContinueButton();
    }

    @Then("I should be navigated to the overview page")
    public void iShouldBeNavigatedToTheOverviewPage() {
        Assert.assertTrue(P05_OverviewPage.isOnOverviewPage(), "Should be on overview page");
    }

    @Then("I should see the correct items total amount")
    public void iShouldSeeTheCorrectItemsTotalAmount() {
        Assert.assertTrue(P05_OverviewPage.getItemTotal() > 0, "Item total should be greater than zero");
    }

    @Then("the URL should match {string}")
    public void theURLShouldMatch(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL should match");
    }

    @When("I click the finish button")
    public void iClickTheFinishButton() {
        P05_OverviewPage.clickFinishButton();
    }

    @Then("I should see the thank you message")
    public void iShouldSeeTheThankYouMessage() {
        Assert.assertTrue(P06_CompletePage.getThankYouMessage().contains("Thank you for your order!"), "Should see thank you message");
    }

    @Then("I should see the order dispatched message")
    public void iShouldSeeTheOrderDispatchedMessage() {
        Assert.assertTrue(P06_CompletePage.getDispatchMessage().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"), "Should see order dispatched message");
    }

    @Then("I should see the appropriate message for {string}")
    public void iShouldSeeTheAppropriateMessageFor(String scenario) {
        switch (scenario) {
            case "success":
                Assert.assertTrue(P02_ProductsPage.isOnProductsPage(), "Should be on products page");
                break;
            case "locked_out":
                Assert.assertTrue(P01_LoginPage.getErrorMessage().contains("locked out"), "Should see locked out message");
                break;
            case "failure":
                Assert.assertFalse(P01_LoginPage.getErrorMessage().isEmpty(), "Should see error message");
                break;
            default:
                throw new IllegalArgumentException("Unknown scenario: " + scenario);
        }
    }
    @Then("I should see the correct items total amount before taxes")
    public void iShouldSeeTheCorrectItemsTotalAmountBeforeTaxes() {
        String actualTotal = P05_OverviewPage.getItemsTotalBeforeTax();
        Assert.assertEquals(actualTotal,"79.98"); // Sum of 49.99 and 29.99
    }

}