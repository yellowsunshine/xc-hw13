package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ContactUsPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");

    public void doVerifyWelcomeTextFromContactUsPage(){
        verificationMethodUsingWait("Contact us", welcomeText, 50);
    }
}
