package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ComingSoonPage extends Utility {

    By welcomeText = By.xpath("//h1[@id='page-title']");


    public void doVerifyWelcomeTextFromComingSoonPage() {
        verificationMethodUsingWait("Coming soon", welcomeText, 50);
    }
}
