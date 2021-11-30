package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

/**
 * 1 - verifySaleProductsArrangeAlphabetically()
 * 		1.1 Mouse hover on the “Hot deals” link
 * 		1.2 Mouse hover on the “Sale”  link and click
 * 		1.3 Verify the text “Sale”
 * 		1.4 Mouse hover on “Sort By” and select “Name A-Z”
 * 		1.5 Verify that the product arrange alphabetically
 * 	2 - verifySaleProductsPriceArrangeLowToHigh()
 * 		2.1 Mouse hover on the “Hot deals” link
 * 		2.2 Mouse hover on the “Sale”  link and click
 * 		2.3 Verify the text “Sale”
 * 		2.4 Mouse hover on “Sort By” and select “Price Low-High”
 * 		2.5 Verify that the product’s price arrange Low to High
 * 	3 - vefirySalesProductsArrangedByRates()
 * 		3.1 Mouse hover on the “Hot deals” link
 * 		3.2 Mouse hover on the “Sale”  link and click
 * 		3.3 Verify the text “Sale”
 * 		3.4 Mouse hover on “Sort By” and select “Rates”
 * 		3.5 Verify that the product’s arrange Rates
 * 	4 - verifyBestSellersProductsArrangeByZToA()
 * 		1.1 Mouse hover on the “Hot deals” link
 * 		1.2 Mouse hover on the “Bestsellers”  link and click
 * 		1.3 Verify the text “Bestsellers”
 * 		1.4 Mouse hover on “Sort By” and select “Name Z-A”
 * 		1.5 Verify that the product arrange by Z to A
 * 	5 - verifyBestSellersProductsPriceArrangeHighToLow()
 * 		2.1 Mouse hover on the “Hot deals” link
 * 		2.2 Mouse hover on the “Bestsellers” link and click
 * 		2.3 Verify the text “Bestsellers”
 * 		2.4 Mouse hover on “Sort By” and select “Price High-Low”
 * 		2.5 Verify that the product’s price arrange High to Low
 * 	6 - verifyBestSellersProductsArrangeByRates()
 * 		3.1 Mouse hover on the “Hot deals” link
 * 		3.2 Mouse hover on the “Bestsellers”  link and click
 * 		3.3 Verify the text “Bestsellers”
 * 		3.4 Mouse hover on “Sort By” and select “Rates”
 * 		3.5 Verify that the product’s arrange Rates
 */

public class HotDealsTest extends TestBase {

    BestSellersPage bestSellersPage = new BestSellersPage();
    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();



    @Test
    public void verifySaleProductsAreArrangedAlphabetically() throws InterruptedException{
        homePage.hoverOnHotDealsLinkAndThenSaleLinkAndClick();
        salePage.doVerifyWelcomeTextFromSalePage();
        salePage.verifyProductsAreSortedAlphabeticallyFromAToZ();
    }

    @Test
    public void verifySaleProductsPriceArrangedLowToHigh() throws InterruptedException{
        /*
        2.1 Mouse hover on the “Hot deals” link
		2.2 Mouse hover on the “Sale”  link and click
		2.3 Verify the text “Sale”
		2.4 Mouse hover on “Sort By” and select “Price Low-High”
		2.5 Verify that the product’s price arrange Low to High
         */
        homePage.hoverOnHotDealsLinkAndThenSaleLinkAndClick();
        salePage.doVerifyWelcomeTextFromSalePage();
        salePage.verifyProductsAreSortedAccordingToPriceLowToHigh();
    }

    @Test
    public void verifySalesProductsArrangedByRates() throws InterruptedException {
        /*
        vefirySalesProductsArrangedByRates()
		3.1 Mouse hover on the “Hot deals” link
		3.2 Mouse hover on the “Sale”  link and click
	    3.3 Verify the text “Sale”
		3.4 Mouse hover on “Sort By” and select “Rates”
		3.5 Verify that the product’s arrange Rates

         */
       homePage.hoverOnHotDealsLinkAndThenSaleLinkAndClick();
       salePage.doVerifyWelcomeTextFromSalePage();
       salePage.verifyProductsAreSortedAccordingToRatingHighToLow();
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        homePage.clickOnBestSellersSubPage();
        bestSellersPage.verifyWelcomeTextFromBestSellersPage();
        bestSellersPage.verifyProductsAreSortedFromZtoA();

    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        homePage.clickOnBestSellersSubPage();
        bestSellersPage.verifyWelcomeTextFromBestSellersPage();
        bestSellersPage.verifyIfProductsAreSortedByPriceHighToLow();
    }

    @Test
    public void verifyBestSellersProductsAreArrangedByRates() throws InterruptedException {
        /*
        3.1 Mouse hover on the “Hot deals” link
		3.2 Mouse hover on the “Bestsellers”  link and click
		3.3 Verify the text “Bestsellers”
		3.4 Mouse hover on “Sort By” and select “Rates”
		3.5 Verify that the product’s arrange Rates
         */

        homePage.hoverOnHotDealsLinkAndClickOnBestSellers();
        bestSellersPage.verifyWelcomeTextFromBestSellersPage();
        bestSellersPage.verifyProductsAreSortedAccordingToRating();




    }




}
