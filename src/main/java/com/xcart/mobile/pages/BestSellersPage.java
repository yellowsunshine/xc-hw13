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
    By sortByZtoAText = By.xpath("//a[normalize-space()='Name Z - A']");
    By productPriceList = By.xpath("//span[@class='price product-price']");
    By sortByHighToLowText = By.xpath("//a[normalize-space()='Price High - Low']");
    By rating = By.xpath("//div[@class='rating']//div//div//div[@style]");
    By sortByRating = By.xpath("//a[normalize-space()='Rates']");
    By allProductsBeforeSorting = By.xpath("//h5[@class='product-name']");


    public void verifyWelcomeTextFromBestSellersPage() {
        verificationMethodUsingWait("Bestsellers", bestSellersWelcomeText, 100);
    }

    public void mouseHoverOnSortBy() {
        doMouseHoverNoClick(sortBy);
    }

    public void clickOnNameAtoZ() {
        doClickOnElement(nameAToZ);
    }

    public void clickOnAddToCartButtonOfVinylIdolGhostBusters() throws InterruptedException {
        doWaitUntilVisibilityOfElementLocated(vinylIdolAddToCart, 100);
    }

    public void verifyProductsAreSortedPriceHighToLow() throws InterruptedException {
        verifyIfProductsAreSortedByPriceHighToLow(productPriceList, sortBy, sortByHighToLowText);
    }

    public void verifyProductsSortedZToA() throws InterruptedException {
        verifyProductsAreSortedFromZtoA(allProductsBeforeSorting, sortBy, sortByZtoAText);
    }

    public void verifyProductsAccordingToRating() throws InterruptedException {
        verifyProductsAreSortedAccordingToRatingHighToLow(rating, sortBy, sortByRating);
    }

}
