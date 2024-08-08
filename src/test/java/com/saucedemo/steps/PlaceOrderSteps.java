package com.saucedemo.steps;

import com.saucedemo.utils.ContextStepDefination;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PlaceOrderSteps {

    ContextStepDefination ContextStepDef;


    public PlaceOrderSteps(ContextStepDefination ContextStepDef) {
        this.ContextStepDef=ContextStepDef;
    }


    @When("I add the two most expensive products to my cart")
    public void iAddTheTwoMostExpensiveProductsToMyCart() {
        ContextStepDef.P02_ProductsPage.addMostExpensiveProducts(2);
    }

    @When("I click on the cart button")
    public void iClickOnTheCartButton() {
        ContextStepDef.P02_ProductsPage.clickCartButton();
    }

    @Then("I should be navigated to the cart page")
    public void iShouldBeNavigatedToTheCartPage() {
        Assert.assertTrue(ContextStepDef.P03_CartPage.isOnCartPage(), "Should be on cart page");
    }

    @Then("I should see the previously selected products in the cart")
    public void iShouldSeeThePreviouslySelectedProductsInTheCart() {
        Assert.assertEquals(ContextStepDef.P03_CartPage.getNumberOfCartItems(), 2, "Should have 2 items in cart");
    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        ContextStepDef.P03_CartPage.clickCheckoutButton();
    }

    @Then("I should be navigated to the checkout page")
    public void iShouldBeNavigatedToTheCheckoutPage() {
        Assert.assertTrue(ContextStepDef.P04_CheckoutPage.isOnCheckoutPage(), "Should be on checkout page");
    }






    @When("I fill in the checkout form with:")
    public void iFillInTheCheckoutFormWith(io.cucumber.datatable.DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("First Name");
        String lastName = data.get(0).get("Last Name");
        String postalCode = data.get(0).get("Postal Code");
        ContextStepDef.P04_CheckoutPage.fillCheckoutForm(firstName, lastName, postalCode);
    }

    @When("I click the continue button")
    public void iClickTheContinueButton() {
        ContextStepDef.P04_CheckoutPage.clickContinueButton();
    }

    @Then("I should be navigated to the overview page")
    public void iShouldBeNavigatedToTheOverviewPage() {
        Assert.assertTrue(ContextStepDef.P05_OverviewPage.isOnOverviewPage(), "Should be on overview page");
    }

    @Then("I should see the correct items total amount")
    public void iShouldSeeTheCorrectItemsTotalAmount() {
        Assert.assertTrue(ContextStepDef.P05_OverviewPage.getItemTotal() > 0, "Item total should be greater than zero");
    }

    @Then("the URL should match {string}")
    public void theURLShouldMatch(String expectedUrl) {
        Assert.assertEquals(ContextStepDef.driver.getCurrentUrl(), expectedUrl, "URL should match");
    }

    @When("I click the finish button")
    public void iClickTheFinishButton() {
        ContextStepDef.P05_OverviewPage.clickFinishButton();
    }

    @Then("I should see the thank you message")
    public void iShouldSeeTheThankYouMessage() {
        Assert.assertTrue(ContextStepDef.P06_CompletePage.getThankYouMessage().contains("Thank you for your order!"), "Should see thank you message");
    }

    @Then("I should see the order dispatched message")
    public void iShouldSeeTheOrderDispatchedMessage() {
        Assert.assertTrue(ContextStepDef.P06_CompletePage.getDispatchMessage().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"), "Should see order dispatched message");
    }

    @Then("I should see the appropriate message for {string}")
    public void iShouldSeeTheAppropriateMessageFor(String scenario) {
        switch (scenario) {
            case "success":
                Assert.assertTrue(ContextStepDef.P02_ProductsPage.isOnProductsPage(), "Should be on products page");
                break;
            case "locked_out":
                Assert.assertTrue(ContextStepDef.P01_LoginPage.getErrorMessage().contains("locked out"), "Should see locked out message");
                break;
            case "failure":
                Assert.assertFalse(ContextStepDef.P01_LoginPage.getErrorMessage().isEmpty(), "Should see error message");
                break;
            default:
                throw new IllegalArgumentException("Unknown scenario: " + scenario);
        }
    }
    @Then("I should see the correct items total amount before taxes")
    public void iShouldSeeTheCorrectItemsTotalAmountBeforeTaxes() {
        String actualTotal = ContextStepDef.P05_OverviewPage.getItemsTotalBeforeTax();
        Assert.assertEquals(actualTotal,"79.98"); // Sum of 49.99 and 29.99
    }
}
