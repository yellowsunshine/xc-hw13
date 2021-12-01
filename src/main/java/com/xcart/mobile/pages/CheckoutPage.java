package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {

    By checkOutPageWelcomeText = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By emailField = By.cssSelector("#email");
    By continueButton = By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]");

    public void verifyCheckoutPageWelcomeText(){
       verificationMethodUsingWait("Log in to your account", checkOutPageWelcomeText, 100);
    }

    public void enterEmailAddressInTheEmailField(){
        doSendTextToElement(emailField, doRandomEmailGenerator());
    }

    public void clickOnTheContinueButton(){
        doClickOnElement(continueButton);
    }




}
