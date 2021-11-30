package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {

    BestSellersPage bestSellersPage = new BestSellersPage();
    ComingSoonPage comingSoonPage = new ComingSoonPage();
    ContactUsPage contactUsPage = new ContactUsPage();
    HomePage homePage = new HomePage();
    NewMenuPage newMenuPage = new NewMenuPage();
    SalePage salePage = new SalePage();
    ShippingPage shippingPage = new ShippingPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    SecureCheckoutPage secureCheckoutPage = new SecureCheckoutPage();
    OrderSuccessfulPage orderSuccessfulPage = new OrderSuccessfulPage();
    VinylIdolzGhosBustersPage vinylIdolzGhosBustersPage = new VinylIdolzGhosBustersPage();

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersProduct() throws InterruptedException {
        homePage.hoverOnHotDealsLinkAndThenSaleLinkAndClick();
        salePage.doVerifyWelcomeTextFromSalePage();
        salePage.mouseHoverOnSortByAndClick();
        salePage.mouseHoverOnAToZAndClick();
        salePage.clickOnAddToCartButton();
        salePage.doVerifyAddToCartConfirmationMessage();
        salePage.clickOnCloseMessageButton();
        salePage.clickOnYourCartAndClickOnViewCart();

        shoppingCartPage.verifyShoppingCartPageText();
        Thread.sleep(5000);
        shoppingCartPage.clearQuantityField();
        Thread.sleep(8000);
        shoppingCartPage.sendUpdatedQuantityToTheQuantityField("2");
        Thread.sleep(5000);
        shoppingCartPage.verifyTheTextYourShoppingCart2Items();
        Thread.sleep(5000);
        shoppingCartPage.verifyTheSubtotalAmount();
        Thread.sleep(5000);
        shoppingCartPage.verifyTheTotalAmount();
        shoppingCartPage.clickOnTheGoToCheckoutButton();

        checkoutPage.verifyCheckoutPageWelcomeText();
        checkoutPage.enterEmailAddressInTheEmailField();
        checkoutPage.clickOnTheContinueButton();

        secureCheckoutPage.doVerifySecureCheckoutWelcomeText();
        secureCheckoutPage.fillMandatoryNameField("Paul");
        secureCheckoutPage.fillMandatoryLastNameField("Smith");
        secureCheckoutPage.fillMandatoryAddressField("1000 Abc Street");
        secureCheckoutPage.fillMandatoryStateField("England");
        secureCheckoutPage.clickOnCreateProfileBox();
        secureCheckoutPage.fillMandatoryPasswordField("MyTopSecret");
        secureCheckoutPage.selectDeliveryMethodAsLocalShipping();
        secureCheckoutPage.selectPaymentMethodAsCOD();
        Thread.sleep(5000);
        secureCheckoutPage.verifyTheTotalAmount();
        secureCheckoutPage.clickOnThePlaceOrderButton();

        orderSuccessfulPage.verifyTheSuccessfulPageWelcomeMessage();
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException{
        homePage.hoverOnHotDealsLinkAndClickOnBestSellers();

        bestSellersPage.verifyWelcomeTextFromBestSellersPage();
        bestSellersPage.mouseHoverOnSortBy();
        Thread.sleep(10000);
        bestSellersPage.clickOnNameAtoZ();
        Thread.sleep(3000);
        bestSellersPage.clickOnAddToCartButtonOfVinylIdolGhostBusters();

        vinylIdolzGhosBustersPage.clickOnAddToCartButton();
        vinylIdolzGhosBustersPage.verifyProductHasBeenAddedToYourCartMessage();
        vinylIdolzGhosBustersPage.closeTheProductHasBeenAddedToYourCartMessage();
        Thread.sleep(3000);
        vinylIdolzGhosBustersPage.clickOnYourCartAndClickOnViewCart();

        shoppingCartPage.verifyShoppingCartPageText();
        shoppingCartPage.clickOnEmptyYourCartLink();
        Thread.sleep(2000);
        shoppingCartPage.verifyTheTextAreYouSureYouWantToClearTheCartFromAlert();
        shoppingCartPage.clickOKOnAlert();
        shoppingCartPage.verifyTheItemDeletedFromYourCartMessage();
        Thread.sleep(3000);
        shoppingCartPage.verifyYourCartIsEmptyMessage();
    }
}
