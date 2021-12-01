package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class NewMenuPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");

    public void doVerifyWelcomeTextFromNewPage(){
        verificationMethodUsingWait("New arrivals", welcomeText, 50);
    }
}
