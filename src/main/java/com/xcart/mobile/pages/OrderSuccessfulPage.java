package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class OrderSuccessfulPage extends Utility {

    By welcomeText = By.cssSelector("#page-title");


    public void verifyTheSuccessfulPageWelcomeMessage() {
        verificationMethodUsingWait("Thank you for your order", welcomeText, 200);
    }
}
