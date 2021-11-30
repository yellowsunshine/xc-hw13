package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class SecureCheckoutPage extends Utility {

    By secureCheckoutWelcomeText = By.cssSelector(".title");
    By name = By.id("shippingaddress-firstname");
    By lastName = By.id("shippingaddress-lastname");
    By address1 = By.id("shippingaddress-street");
    By state = By.id("shippingaddress-custom-state");
    By createProfileButton = By.id("create_profile");
    By password = By.id("password");
    By localShipping = By.id("method128");
    By paymentMethod = By.id("pmethod6");
    By totalAmount = By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']");
    By placeOrderButton = By.cssSelector("button[class='btn regular-button regular-main-button place-order submit']");




    public String getTextFromSecureCheckoutWelcomeText() {
        return doGetTextFromElement(secureCheckoutWelcomeText);
    }

    public void doVerifySecureCheckoutWelcomeText() {
        String expectedMessage = "Secure Checkout";
        String actualMessage = getTextFromSecureCheckoutWelcomeText();
        doVerifyElements(expectedMessage, actualMessage, "Welcome Text is incorrect");
    }

    public void fillMandatoryNameField(String nm) {
        doSendTextToElement(name, nm);
    }

    public void fillMandatoryLastNameField(String ln) {
        doSendTextToElement(lastName, ln);
    }

    public void fillMandatoryAddressField(String add) {
        doSendTextToElement(address1, add);
    }

    public void fillMandatoryStateField(String st) {
        doSendTextToElement(state, st);
    }

    public void clickOnCreateProfileBox(){
        doClickOnElement(createProfileButton);
    }

    public void fillMandatoryPasswordField(String pwd) {
        doSendTextToElement(password, pwd);
    }

    public void selectDeliveryMethodAsLocalShipping(){
        doClickOnElement(localShipping);
    }

    public void selectPaymentMethodAsCOD(){
        doClickOnElement(paymentMethod);
    }

    public String getTextFromTheTotalAmountElement(){
        return doGetTextFromElement(totalAmount);
    }

    public void verifyTheTotalAmount(){
        String expectedAmount = "$37.03";
        String actualAmount = getTextFromTheTotalAmountElement();
        doVerifyElements(expectedAmount, actualAmount, "Total Amount is incorrect");
    }

    public void clickOnThePlaceOrderButton(){
        doClickOnElement(placeOrderButton);

    }





}
