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
    By allProducts = By.xpath("//h5[@class='product-name']");
    By aToZ = By.partialLinkText("Name A -");
    By preAddToCart = By.xpath("//a[@class='product-thumbnail next-previous-assigned']");
    By addToCart = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addToCartGreenMessage = By.xpath("//li[@class='info']");
    By closeMessageButton = By.cssSelector("a[title='Close']");
    By yourCart = By.xpath("//div[@title='Your cart']");
    By viewCart = By.xpath("//span[normalize-space()='View cart']");
    By ddBox = By.cssSelector(".sort-by-value");
    By lowTHigh = By.partialLinkText("Price Low - Hi");
    By productRating = By.xpath("//div[@class='rating']//div//div//div[@style]");
    By sortByRating = By.xpath("//a[normalize-space()='Rates']");


    public String getTextFromSalePageWelcomeTextElement(){
        return doGetTextFromElement(saleWelcomeText);
    }

    public void doVerifyWelcomeTextFromSalePage(){
        String expectedMessage = "Sale";
        String actualMessage = getTextFromSalePageWelcomeTextElement();
        doVerifyElements(expectedMessage, actualMessage, "Welcome text is not displayed correctly");

    }

    public void mouseHoverOnSortByAndClick(){
        doMouseHoverAndClick(sortBy);
    }

    public void mouseHoverOnAToZAndClick(){
        doMouseHoverAndClick(aToZ);
    }



    public void verifyProductsAreSortedAlphabeticallyFromAToZ() throws InterruptedException {

        List<WebElement> originalList = driver.findElements(By.xpath("//h5[@class='product-name']"));
        List<String> originalProductRatingList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRatingList.add(product.getText());
        }
        Collections.sort(originalProductRatingList, Collections.reverseOrder());
        System.out.println(originalProductRatingList);

        mouseHoverOnSortByAndClick();
        mouseHoverOnAToZAndClick();

        List<WebElement> afterSortingList = driver.findElements(allProducts);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals(originalProductRatingList, afterSortingProductName, "Products are not sorted");
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        doMouseHoverNoClick(preAddToCart);
        Thread.sleep(5000);
        doClickOnElement(addToCart);

    }

    public String getTextFromAddToCartConfirmationMessageElement(){
        return doGetTextFromElement(addToCartGreenMessage);
    }

    public void doVerifyAddToCartConfirmationMessage(){
        String expectedMessage = "Product has been added to your cart";
        String actualMessage = getTextFromAddToCartConfirmationMessageElement();
        doVerifyElements(expectedMessage, actualMessage, "Message is not displayed correctly");

    }

    public void clickOnCloseMessageButton(){
        doClickOnElement(closeMessageButton);
    }

    public void clickOnYourCartAndClickOnViewCart() throws InterruptedException{
        doClickOnElement(yourCart);
        Thread.sleep(5000);
        doClickOnElement(viewCart);
    }

    public void verifyProductsAreSortedAccordingToPriceLowToHigh(){
        verifyTheSortingOrderOfPriceLowToHighIsCorrect(By.className("product-price"), ddBox, lowTHigh);
    }

    public void verifyProductsAreSortedAccordingToRatingHighToLow() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productRating);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating :originalList) {
        originalProductRating.add(rating.getAttribute("style").indexOf(3, 6));
        }

        Collections.sort(originalProductRating,Collections.reverseOrder());
        doMouseHoverNoClick(sortBy);
        doMouseHoverAndClick(sortByRating);
        Thread.sleep(3000);
        List<WebElement> afterSortingList = driver.findElements(productRating);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating1 :afterSortingList){
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(2, 6));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals(originalProductRating,afterSortingProductRating,"products are not sorted");

    }




}
