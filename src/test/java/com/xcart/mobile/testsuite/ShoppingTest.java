package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {

    BestSellersPage bestSellersPage = new BestSellersPage();
    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    SecureCheckoutPage secureCheckoutPage = new SecureCheckoutPage();
    OrderSuccessfulPage orderSuccessfulPage = new OrderSuccessfulPage();
    VinylIdolzGhosBustersPage vinylIdolzGhostBustersPage = new VinylIdolzGhosBustersPage();

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
        shoppingCartPage.clearQuantityField();
        Thread.sleep(5000);
        shoppingCartPage.sendUpdatedQuantityToTheQuantityField("");
        shoppingCartPage.sendUpdatedQuantityToTheQuantityField("2");
        shoppingCartPage.verifyTheTextYourShoppingCart2Items();
        shoppingCartPage.verifyTheSubtotalAmount();
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
        secureCheckoutPage.clickOnThePlaceOrderButton();
        Thread.sleep(5000);
        orderSuccessfulPage.verifyTheSuccessfulPageWelcomeMessage();
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException{
        homePage.hoverOnHotDealsLinkAndClickOnBestSellers();

        bestSellersPage.verifyWelcomeTextFromBestSellersPage();
        bestSellersPage.mouseHoverOnSortBy();
        bestSellersPage.clickOnNameAtoZ();
        bestSellersPage.clickOnAddToCartButtonOfVinylIdolGhostBusters();

        vinylIdolzGhostBustersPage.clickOnAddToCartButton();
        vinylIdolzGhostBustersPage.verifyProductHasBeenAddedToYourCartMessage();
        vinylIdolzGhostBustersPage.closeTheProductHasBeenAddedToYourCartMessage();
        vinylIdolzGhostBustersPage.clickOnYourCartAndClickOnViewCart();

        shoppingCartPage.verifyShoppingCartPageText();
        shoppingCartPage.clickOnEmptyYourCartLink();
        shoppingCartPage.verifyTheTextAreYouSureYouWantToClearTheCartFromAlert();
        shoppingCartPage.clickOKOnAlert();
        shoppingCartPage.verifyTheItemDeletedFromYourCartMessage();
        shoppingCartPage.verifyYourCartIsEmptyMessage();
    }
}
