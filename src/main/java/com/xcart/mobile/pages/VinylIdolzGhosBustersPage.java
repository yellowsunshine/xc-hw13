package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class VinylIdolzGhosBustersPage extends Utility {

    By addToCartButton = By.xpath("(//span[contains(text(),'Add to cart')])[1]");
    By productAdded = By.xpath("//li[contains(text(),'Product has been added to your cart')]");
    By closeButton = By.xpath("//a[@title='Close']");
    By yourCart = By.xpath("//div[@title='Your cart']");
    By viewCart = By.xpath("//span[contains(text(),'View cart')]");

    public void clickOnAddToCartButton() throws InterruptedException {
        doMouseHoverNoClick(addToCartButton);
        Thread.sleep(5000);
        doClickOnElement(addToCartButton);
    }

    public String getTextFromProductHasBeenAddedToYourCartMessage(){
        return doGetTextFromElement(productAdded);
    }

    public void verifyProductHasBeenAddedToYourCartMessage(){
        String expectedMessage = "Product has been added to your cart";
        String actualMessage = getTextFromProductHasBeenAddedToYourCartMessage();
        doVerifyElements(expectedMessage, actualMessage, "Message is not displayed correctly");
    }

    public void closeTheProductHasBeenAddedToYourCartMessage(){
        doClickOnElement(closeButton);

    }

    public void clickOnYourCartAndClickOnViewCart() throws InterruptedException {
        doClickOnElement(yourCart);
        Thread.sleep(2000);
        doClickOnElement(viewCart);
    }


}
