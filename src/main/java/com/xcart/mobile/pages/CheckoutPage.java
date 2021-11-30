package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {

    By checkOutPageWelcomeText = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By emailField = By.cssSelector("#email");
    By continueButton = By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]");






    public String getTextFromCheckOutPageWelcomeText(){
       return doGetTextFromElement(checkOutPageWelcomeText);
    }

    public void verifyCheckoutPageWelcomeText(){
        String expectedMessage = "Log in to your account";
        String actualMessage = getTextFromCheckOutPageWelcomeText();
        doVerifyElements(expectedMessage, actualMessage, "Checkout Page Welcome Text is incorrect");
    }

    public void enterEmailAddressInTheEmailField(){
        doSendTextToElement(emailField, doRandomEmailGenerator());
    }

    public void clickOnTheContinueButton(){
        doClickOnElement(continueButton);
    }




}
