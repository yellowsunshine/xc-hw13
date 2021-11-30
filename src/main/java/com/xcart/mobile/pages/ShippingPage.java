package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ShippingPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");

    public String getTextFromShippingPageWelcomeTextElement(){
        return doGetTextFromElement(welcomeText);
    }

    public void doVerifyWelcomeTextFromShippingPage(){
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromShippingPageWelcomeTextElement();
        doVerifyElements(expectedMessage, actualMessage, "Welcome text is not displayed correctly");
    }
}
