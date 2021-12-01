package com.xcart.mobile.testsuite;
import com.xcart.mobile.pages.*;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    /**
     * Create package homepage
     * Create class TopMenuTest
     * 1 - verifyUserShouldNavigateToShippingPageSuccessfully()
     * 1.1 Click on the “Shipping” link
     * 1.2 Verify the text “Shipping”
     * 2 - verifyUserShouldNavigateToNewPageSuccessfully()
     * 2.1 Click on the “New!” link
     * 2.2 Verify the text “New arrivals”
     * 3 - verifyUserShouldNavigateToComingsoonPageSuccessfully()
     * 3.1 Click on the “Coming soon” link
     * 3.2 Verify the text “Coming soon”
     * 4 - verifyUserShouldNavigateToContactUsPageSuccessfully()
     * 4.1 Click on the “Contact us” link
     * 4.2 Verify the text “Contact us”
     */

    ComingSoonPage comingSoonPage = new ComingSoonPage();
    ContactUsPage contactUsPage = new ContactUsPage();
    HomePage homePage = new HomePage();
    NewMenuPage newMenuPage = new NewMenuPage();
    ShippingPage shippingPage = new ShippingPage();

    @Test
    public void userShouldBeAbleToNavigateToShippingPageSuccessfully() throws InterruptedException {
        homePage.navigateToAPageSuccessfully("Shipping");
        shippingPage.doVerifyWelcomeTextFromShippingPage();
    }

    @Test
    public void userShouldBeAbleToNavigateToNewPageSuccessfully() throws InterruptedException {
        homePage.navigateToAPageSuccessfully("New!");
        newMenuPage.doVerifyWelcomeTextFromNewPage();
    }

    @Test
    public void userShouldBeAbleToNavigateToComingSoonPageSuccessfully() throws InterruptedException {
        homePage.navigateToAPageSuccessfully("Coming soon");
        comingSoonPage.doVerifyWelcomeTextFromComingSoonPage();
    }

    @Test
    public void userShouldBeAbleToNavigateToContactUsPageSuccessfully() throws InterruptedException {
        homePage.navigateToAPageSuccessfully("Contact us");
        contactUsPage.doVerifyWelcomeTextFromContactUsPage();
    }
}
