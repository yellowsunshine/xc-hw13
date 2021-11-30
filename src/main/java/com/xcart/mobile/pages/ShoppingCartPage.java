package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

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


    public String getTextFromShoppingCartPageText() {
        return doGetTextFromElement(shoppingCartText);
    }

    public void verifyShoppingCartPageText() {
        String expectedMessage = "Your shopping cart - 1 item";
        doVerifyElements(expectedMessage, getTextFromShoppingCartPageText(), "Shopping cart display text is not displayed correctly");
    }

    public void clearQuantityField() throws InterruptedException {
        doFindElementAndClearText(quantityClear);
        Thread.sleep(2000);
    }

    public void sendUpdatedQuantityToTheQuantityField(String quantity){
        doSendTextToElement(addQuantity, quantity);
    }

    public String getTextFromShoppingCartItemMessage(){
        return doGetTextFromElement(shoppingCartItemsText);
    }

    public void verifyTheTextYourShoppingCart2Items(){
        String expectedQty = "Your shopping cart - 2 items";
        String actualQty = getTextFromShoppingCartItemMessage();
        doVerifyElements(expectedQty, actualQty, "Message is displayed incorrectly");
    }

    public String getTextFromSubtotalElement(){
        return doGetTextFromElement(subtotal);
    }


    public void verifyTheSubtotalAmount(){
        String expectedSubtotal = "$29.98";
        String actualSubtotal = getTextFromSubtotalElement();
        doVerifyElements(expectedSubtotal, actualSubtotal, "Subtotal Amount is Incorrect");
    }

    public String getTextFromTotalAmountElement(){
        return doGetTextFromElement(totalAmount);
    }


    public void verifyTheTotalAmount(){
        String expectedSubtotal = "$36.00";
        String actualSubtotal = getTextFromTotalAmountElement();
        doVerifyElements(expectedSubtotal, actualSubtotal, "Total Amount is Incorrect");
    }

    public void clickOnTheGoToCheckoutButton(){
        doClickOnElement(checkoutButton);
    }

    public void clickOnEmptyYourCartLink(){
        doClickOnElement(emptyCartLink);
    }

    public void verifyTheTextAreYouSureYouWantToClearTheCartFromAlert(){
        String actualAlert = doGetTextFromAlert();
        String expectedAlert = "Are you sure you want to clear your cart?";
        doVerifyElements(expectedAlert, actualAlert, "Alert message is incorrect");
    }

    public void clickOKOnAlert(){
        doAcceptAlert();
    }

    public String getTextFromDeletedMessage(){
        return doGetTextFromElement(itemDeletedMessage);
    }

    public void verifyTheItemDeletedFromYourCartMessage(){
        String expectedMessage = "Item(s) deleted from your cart";
        String actualMessage = getTextFromDeletedMessage();
        doVerifyElements(expectedMessage, actualMessage, "Message is displayed incorrectly");
    }

    public String getTextFromYourCartIsEmptyMessage(){
        return doGetTextFromElement(emptyCartMessage);
    }

    public void verifyYourCartIsEmptyMessage(){
        String expectedMessage = "Your cart is empty";
        String actualMessage = getTextFromYourCartIsEmptyMessage();
        doVerifyElements(expectedMessage, actualMessage, "Message is displayed incorrectly");
    }




}
