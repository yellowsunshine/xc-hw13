package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends Utility {

    By shoppingCartText = By.xpath("//h1[@id='page-title']");
    By quantityClear = By.xpath("//input[@id='amount16']");
    By addQuantity = By.xpath("//input[@id='amount16' and @ name='amount']");
    By shoppingCartItemsText = By.xpath("//h1[@id='page-title']");
    By subtotal = By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']");
    By totalAmount = By.xpath("//li[@class='total']//span[@class='surcharge']");
    By checkoutButton = By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]");
    By emptyCartLink = By.xpath("//a[contains(text(),'Empty your cart')]");
    By itemDeletedMessage = By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]");
    By emptyCartMessage = By.xpath("//h1[normalize-space()='Your cart is empty']");


    public void verifyShoppingCartPageText() {
        //String expectedMessage = "Your shopping cart - 1 item";
        //doVerifyElements(expectedMessage, getTextFromShoppingCartPageText(), "Shopping cart display text is not displayed correctly");
        verificationMethodUsingWait("Your shopping cart - 1 item", shoppingCartText, 100);
    }

    public void clearQuantityField() {
        doWaitUntilVisibilityOfElementLocated(quantityClear, 50).clear();
    }

    public void sendUpdatedQuantityToTheQuantityField(String quantity) {
        doWaitUntilVisibilityOfElementLocated(addQuantity, 100).sendKeys(quantity);
    }

    public void verifyTheTextYourShoppingCart2Items() {
        String expectedMessage = doWaitUntilTitleIsEqualTo("Your shopping cart - 2 items");
        verificationMethodUsingWait(expectedMessage, shoppingCartItemsText, 150);
    }

    public String getTextFromSubtotalElement() {
        return doGetTextFromElement(subtotal);
    }


    public void verifyTheSubtotalAmount() {
        String expectedSubtotal = "$29.98";
        String actualSubtotal = getTextFromSubtotalElement();
        doVerifyElements(expectedSubtotal, actualSubtotal, "Subtotal Amount is Incorrect");
        //verificationMethodUsingWait("$29.98", subtotal, 150 );
    }

    public String getTextFromTotalAmountElement() {
        return doGetTextFromElement(totalAmount);
    }


    public void verifyTheTotalAmount() {
        String expectedSubtotal = "$36.00";
        String actualSubtotal = getTextFromTotalAmountElement();
        doVerifyElements(expectedSubtotal, actualSubtotal, "Total Amount is Incorrect");
    }

    public void clickOnTheGoToCheckoutButton() {
        doClickOnElement(checkoutButton);
    }

    public void clickOnEmptyYourCartLink() {
        doClickOnElement(emptyCartLink);
    }

    public void verifyTheTextAreYouSureYouWantToClearTheCartFromAlert() {
        String actualAlert = doGetTextFromAlert();
        String expectedAlert = "Are you sure you want to clear your cart?" ;
        doVerifyElements(expectedAlert, actualAlert, "Alert message is incorrect");

    }

    public void clickOKOnAlert() {
        doAcceptAlert();
    }

    public void verifyTheItemDeletedFromYourCartMessage() {
        verificationMethodUsingWait("Item(s) deleted from your cart", itemDeletedMessage, 50);
    }

    public void verifyYourCartIsEmptyMessage() {
        verificationMethodUsingWait("Your cart is empty", emptyCartMessage, 50);
    }


}
