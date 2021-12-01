package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalePage extends Utility {


    By saleWelcomeText = By.xpath("//h1[@id='page-title']");
    By sortBy = By.xpath("//span[@class='sort-by-value']");
    By aToZ = By.partialLinkText("Name A -");
    By preAddToCart = By.xpath("//a[@class='product-thumbnail next-previous-assigned']");
    By addToCart = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addToCartGreenMessage = By.xpath("//li[@class='info']");
    By closeMessageButton = By.cssSelector("a[title='Close']");
    By yourCart = By.xpath("//div[@title='Your cart']");
    By viewCart = By.xpath("//span[normalize-space()='View cart']");
    By ddBox = By.cssSelector(".sort-by-value");
    By lowTHigh = By.partialLinkText("Price Low - Hi");
    By sortByRating = By.xpath("//a[normalize-space()='Rates']");
    By alphaAllProducts = By.xpath("//h5[@class='product-name']");


    public void doVerifyWelcomeTextFromSalePage() {
        verificationMethodUsingWait("Sale", saleWelcomeText, 50);
    }

    public void mouseHoverOnSortByAndClick() {
        doMouseHoverAndClick(sortBy);
    }

    public void mouseHoverOnAToZAndClick() {
        doMouseHoverAndClick(aToZ);
    }


    public void clickOnAddToCartButton() {
        doMouseHoverNoClick(preAddToCart);
        doWaitUntilVisibilityOfElementLocated(addToCart, 50).click();
    }

    public String getTextFromAddToCartConfirmationMessageElement() {
        return doGetTextFromElement(addToCartGreenMessage);
    }

    public void doVerifyAddToCartConfirmationMessage() {
        String expectedMessage = "Product has been added to your cart";
        String actualMessage = getTextFromAddToCartConfirmationMessageElement();
        doVerifyElements(expectedMessage, actualMessage, "Message is not displayed correctly");
    }

    public void clickOnCloseMessageButton() {
        doClickOnElement(closeMessageButton);
    }

    public void clickOnYourCartAndClickOnViewCart() throws InterruptedException {
        doWaitUntilVisibilityOfElementLocated(yourCart, 100).click();
        Thread.sleep(5000);
        doWaitUntilVisibilityOfElementLocated(viewCart, 100).click();
    }

    public void verifyProductsAreSortedAccordingToPriceLowToHigh() {
        verifyTheSortingOrderOfPriceLowToHighIsCorrect(By.className("product-price"), ddBox, lowTHigh);
    }

    public void verifyProductsAreSortedAlphabetically() throws InterruptedException {
        verifyProductsAreSortedAlphabeticallyFromAToZ(alphaAllProducts, ddBox, aToZ);
    }

    public void verifyProductsAreSortedAccordingToTheirRatings() throws InterruptedException {
        verifyProductsAreSortedAccordingToRatingHighToLow(sortByRating, ddBox, sortByRating);
    }


}
