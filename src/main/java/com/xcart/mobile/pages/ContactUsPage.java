package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ContactUsPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");

    public String getTextFromContactUsPageWelcomeTextElement(){
        return doGetTextFromElement(welcomeText);
    }

    public void doVerifyWelcomeTextFromContactUsPage(){
        String expectedMessage = "Contact us";
        String actualMessage = getTextFromContactUsPageWelcomeTextElement();
        doVerifyElements(expectedMessage, actualMessage, "Welcome text is not displayed correctly");
    }
}
