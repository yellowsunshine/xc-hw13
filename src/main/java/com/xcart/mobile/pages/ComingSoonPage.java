package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ComingSoonPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");

    public String getTextFromComingSoonPageWelcomeTextElement(){
        return doGetTextFromElement(welcomeText);
    }

    public void doVerifyWelcomeTextFromComingSoonPage(){
        String expectedMessage = "Coming soon";
        String actualMessage = getTextFromComingSoonPageWelcomeTextElement();
        doVerifyElements(expectedMessage, actualMessage, "Welcome text is not displayed correctly");
    }
}
