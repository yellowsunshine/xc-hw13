package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By hotDealsLink = By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']");
    By saleLink = By.xpath("(//span[contains(text(),'Sale')])[2]");
    By topMenuLink = By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li");
    By bestSellersLink = By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span");



    public void navigateToAPageSuccessfully(String menuSelection) throws InterruptedException {
        selectMenu(topMenuLink, menuSelection);
    }

    public void hoverOnHotDealsLinkAndThenSaleLinkAndClick(){
        doMouseHoverOnFirstThenSecondAndClick(hotDealsLink, saleLink);
    }

    public void hoverOnHotDealsLinkAndClickOnBestSellers(){
        doMouseHoverOnFirstThenSecondAndClick(hotDealsLink, bestSellersLink );
    }

    public void clickOnBestSellersSubPage() throws InterruptedException {
        doMouseHoverNoClick(hotDealsLink);
        doMouseHoverAndClick(bestSellersLink);
    }
}
