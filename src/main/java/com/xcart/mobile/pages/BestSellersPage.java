package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSellersPage extends Utility {

    By bestSellersWelcomeText = By.xpath("//h1[@id='page-title']");
    By sortBy = By.xpath("//span[@class='sort-by-value']");
    By nameAToZ = By.partialLinkText("Name A - Z");
    By vinylIdolAddToCart = By.xpath("//a[normalize-space()='Vinyl Idolz: Ghostbusters']");
    By priceHighToLow = By.partialLinkText("Price High - L");
    By productList = By.xpath("//h5[@class='product-name']");
    By sortByZtoAText = By.xpath("//a[normalize-space()='Name Z - A']");
    By productPriceList = By.xpath("//span[@class='price product-price']");
    By sortByHighToLowText = By.xpath("//a[normalize-space()='Price High - Low']");
    By rating = By.xpath("//div[@class='rating']//div//div//div[@style]");
    By sortByRating = By.xpath("//a[normalize-space()='Rates']");
    By allProductsBeforeSorting = By.xpath("//h5[@class='product-name']");






    public String getTextFromBestSellersWelcomeText(){
        return doGetTextFromElement(bestSellersWelcomeText);
    }

    public void verifyWelcomeTextFromBestSellersPage(){
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromBestSellersWelcomeText();
        doVerifyElements(expectedMessage, actualMessage, "Welcome Text is incorrect");
    }

    public void mouseHoverOnSortBy(){
        doMouseHoverNoClick(sortBy);
    }

    public void clickOnNameAtoZ(){
        doClickOnElement(nameAToZ);
    }

    public void clickOnAddToCartButtonOfVinylIdolGhostBusters() throws InterruptedException {
        //doMouseHoverNoClick(vinylIdolImage);
        //Thread.sleep(2000);
        doClickOnElement(vinylIdolAddToCart);
    }

    public void clickOnPriceHighToLow(){
        doClickOnElement(priceHighToLow);
    }

    public void verifyIfProductsAreSortedByPriceHighToLow() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productPriceList);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price :originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$","")));
        }

        System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList,Collections.reverseOrder());
        doMouseHoverNoClick(sortBy);
        doMouseHoverAndClick(sortByHighToLowText);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productPriceList);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 :afterSortingList){
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$","")));
        }
        System.out.println(afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList,afterSortingProductPrice,"products are not sorted");

    }


    public void verifyProductsAreSortedFromZtoA() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(allProductsBeforeSorting);//get all products
        List<String> originalProductNameList = new ArrayList<>();//store them in list of strings
        for (WebElement product :originalList) {
            originalProductNameList.add(product.getText());//convert each string into text
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        System.out.println("Expected Result is : " +originalProductNameList);
        doMouseHoverNoClick(sortBy);
        doMouseHoverAndClick(sortByZtoAText);
        Thread.sleep(3000);


        List<WebElement> afterSortingList = driver.findElements(allProductsBeforeSorting);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 :afterSortingList){
            afterSortingProductName.add(product1.getText());
           }
        System.out.println("actual result is : )"+ afterSortingProductName);

        Assert.assertEquals(originalProductNameList,afterSortingProductName,"products are now sorted");

    }

    public void verifyProductsAreSortedAccordingToRating() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(rating);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating :originalList) {
            originalProductRating.add(rating.getAttribute("style").indexOf(2, 7));
        }

        Collections.sort(originalProductRating,Collections.reverseOrder());
        doMouseHoverNoClick(sortBy);
        doMouseHoverAndClick(sortByRating);
        Thread.sleep(3000);
        List<WebElement> afterSortingList = driver.findElements(rating);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating1 :afterSortingList){
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(2, 6));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals(originalProductRating,afterSortingProductRating,"products are not sorted");

    }

















}
