package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class NewMenuPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");

    public String getTextFromNewPageWelcomeTextElement(){
        return doGetTextFromElement(welcomeText);
    }

    public void doVerifyWelcomeTextFromNewPage(){
        String expectedMessage = "New arrivals";
        String actualMessage = getTextFromNewPageWelcomeTextElement();
        doVerifyElements(expectedMessage, actualMessage, "Welcome text is not displayed correctly");
    }
}
