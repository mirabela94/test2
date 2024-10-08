package com.magento.softwaretestingboard.tests;


<<<<<<< HEAD
import com.magento.softwaretestingboard.pages.ViewAndEditCart;
import org.testng.Assert;
import org.testng.annotations.Test;


=======
import org.testng.Assert;
import org.testng.annotations.Test;

>>>>>>> ab13cc37fb18520cd61f6c4568c33526ff451e96
public class EcommerceShoppingFlowTest extends BaseTest {

    //     Test 2: Add 2 Products to the Shopping Cart and Proceed to Checkout
    @Test(priority = 1)
    public void addProductsToCart() throws InterruptedException {
            homePage.navigateToHomePage();
            homePage.clickSignIn();

            // Utilizes the email and password
            loginPage.enterRegisteredEmail("tudoranmirabela@gmail.com");
            loginPage.enterRegisteredPassword("tudoranmirabela123!");

            loginPage.clickSignInButton();
<<<<<<< HEAD
           // wait(10);



            homePage.hoverToMenMenu();
           // homePage.checkCartItems();
            homePage.hoverToTops();
            homePage.clickOnJackets();


=======
            homePage.hoverToMenMenu();
            homePage.hoverToTops();
            homePage.clickOnJackets();

>>>>>>> ab13cc37fb18520cd61f6c4568c33526ff451e96
            menJacketsPage.addToCartBlackXLFitnessJackshirt();
//            // Assert the addition of 'Proteus Fitness JackShirt' product to the shopping cart.
            Assert.assertEquals(menJacketsPage.getSuccessMessageFitnessJackshirt(), "You added Proteus Fitness Jackshirt to your shopping cart.",
                    "'Proteus Fitness JackShirt' product was not added to the shopping cart.");

            menJacketsPage.addToCartGreenXLWindJackshirt();
//            // Assert the addition of 'Montana Wind Jacket' product to the shopping cart.
            Assert.assertEquals(menJacketsPage.getSuccessMessageWindJacket(), "You added Montana Wind Jacket to your shopping cart.",
                    "'Montana Wind Jacket' product was not added to the shopping cart.");

            menJacketsPage.clickProceedToCheckout();
<<<<<<< HEAD
          // Assert that the user is redirected to 'Checkout' page.
            Assert.assertTrue(checkoutShippingPage.isOnCheckoutPage(),
                    "User is NOT redirected to the 'Checkout' page");

           // Assert that the Order Summary on the Checkout page correctly displays the number of items added.
=======
//            // Assert that the user is redirected to 'Checkout' page.
            Assert.assertTrue(checkoutShippingPage.isOnCheckoutPage(),
                    "User is NOT redirected to the 'Checkout' page");

//            // Assert that the Order Summary on the Checkout page correctly displays the number of items added.
>>>>>>> ab13cc37fb18520cd61f6c4568c33526ff451e96
           // Assert.assertEquals(checkoutShippingPage.getCartSummaryItemsCount(), "2",
           //         "Order Summary on the Checkout page DID NOT correctly display the number of added items.");

            checkoutShippingPage.clickOrderSummaryLink(3);

            // Asserting that the correct products, quantities, and prices are added to the cart.
            Assert.assertEquals(checkoutShippingPage.getProductOneName(), "Proteus Fitness Jackshirt",
                    "Product name mismatch for the first cart item.");
            Assert.assertEquals(checkoutShippingPage.getProductOneQty(), "1",
                    "Quantity mismatch for the first cart item.");
            Assert.assertEquals(checkoutShippingPage.getProductOnePrice(), "$45.00",
                    "Price mismatch for the first item.");
            Assert.assertEquals(checkoutShippingPage.getProductTwoName(), "Montana Wind Jacket",
                    "Product name mismatch for the second cart item.");
            Assert.assertEquals(checkoutShippingPage.getProductTwoQty(), "1",
                    "Quantity mismatch for the second cart item.");
            Assert.assertEquals(checkoutShippingPage.getProductTwoPrice(), "$49.00",
                    "Price mismatch for the second cart item.");

    }

    // Test 3: End-to-End Test of the Entire Flow
    @Test(priority = 2)
    public void endToEnd() throws InterruptedException {
            homePage.navigateToHomePage();
            homePage.clickSignIn();


//            //Assert User is navigated to 'Customer LoginPage' Page.
            Assert.assertTrue(loginPage.isOnLoginPage(),
                    "User is not on the 'Customer LoginPage' Page.");

            // Utilizes the email and password
            loginPage.enterRegisteredEmail("tudoranmirabela@gmail.com");
            loginPage.enterRegisteredPassword("tudoranmirabela123!");

            loginPage.clickSignInButton();

//            // Assert that the user is redirected to 'HomePage' page after successful LoginPage.
            Assert.assertTrue(myAccountPage.isOnHomePage(),
                    "The user was not redirected to the 'HomePage' page after successful loginPage.");

//            // Assert Welcome message and the customer Full Name on User Account Menu Element.
            Assert.assertEquals(homePage.checkWelcomeMessageOnuSearchCountMenu(), "Welcome, mirabela mirabela!",
                    "The welcome message and customer name on the User Account Menu do not match the expected values.");

//            //Assert that 'Main Store Navigation Menu' is displayed on 'My Account' page.
            Assert.assertTrue(myAccountPage.mainStoreMenuIsDisplayed(),
                    "The 'Main Store Navigation Menu' is not displayed on the 'My Account' page.");

            homePage.hoverToMenMenu();
            homePage.hoverToTops();
            homePage.clickOnJackets();

            menJacketsPage.addToCartBlackXLFitnessJackshirt();
//            // Assert the addition of 'Proteus Fitness JackShirt' product to the shopping cart.
            Assert.assertEquals(menJacketsPage.getSuccessMessageFitnessJackshirt(), "You added Proteus Fitness Jackshirt to your shopping cart.",
                    "The product 'Proteus Fitness JackShirt' was not successfully added to the shopping cart.");


            menJacketsPage.addToCartGreenXLWindJackshirt();
//            // Assert the addition of 'Montana Wind Jacket' product to the shopping cart.
            Assert.assertEquals(menJacketsPage.getSuccessMessageWindJacket(), "You added Montana Wind Jacket to your shopping cart.",
                    "The product 'Montana Wind Jacket' was not successfully added to the shopping cart.");


            menJacketsPage.clickProceedToCheckout();
            // Assert successful navigation to the 'Checkout' page.
            Assert.assertTrue(checkoutShippingPage.isOnCheckoutPage(),
                    "The user was not redirected to the expected 'Checkout' page.");


            // Assert that 'North Macedonia' is available country in Country Drop Down menu.
            Assert.assertTrue(checkoutShippingPage.checkNorthMacedoniaIsListed("North Macedonia"),
                    "'North Macedonia' is not available");

            checkoutShippingPage.selectCountry("North Macedonia");
            checkoutShippingPage.enterStreetAddress("3 MUB");
            checkoutShippingPage.enterCity("Skopje");
            checkoutShippingPage.enterZipCode("1000");
            checkoutShippingPage.enterPhoneNumber("+38977334455");
            checkoutShippingPage.selectFixedShippingMethod();
            checkoutShippingPage.clickNextButtonToThePayment();

            // Assert successful navigation to the 'Payment' page.
            Assert.assertTrue(checkoutPaymentsPage.isOnPaymentPage(),
                    "The navigation to the 'Payment' page was not successful.");

            // Assert Cart item count.
            Assert.assertEquals(checkoutPaymentsPage.getTotalItemsInCart(), "4",
                    "The total number of items in the cart does not match the expected count.");

            // Assert Cart Subtotal price, Shipping Price and Order Total Price.
            Assert.assertEquals(checkoutPaymentsPage.getCartSubtotalPrice(), "$188.00",
                    "The 'Cart Subtotal' price does not match expected value");
            Assert.assertEquals(checkoutPaymentsPage.getShippingPrice(), "$20.00",
                    "The 'Shipping' price does not match expected value");
            Assert.assertEquals(checkoutPaymentsPage.getOrderTotalPrice(), "$208.00",
                    "The 'Order Total' price does not match expected value");

            // Assert shipping information.
            Assert.assertEquals(checkoutPaymentsPage.getShipToInformation().replaceAll("\\s+", " ").trim(),
                    getRandomFirstName + " " + getRandomLastName + " 3 MUB Skopje, 1000 North Macedonia +38977334455",
                    "Shipping information does not match the expected value.");

            checkoutPaymentsPage.clickOnItemsInCartDropDown(3);
            // Assert the Order summary products prices.
            Assert.assertEquals(checkoutPaymentsPage.getProductOnePrice(), "$90.00",
                    "The price for the first item in the order summary is incorrect.");
            Assert.assertEquals(checkoutPaymentsPage.getProductTwoPrice(), "$98.00",
                    "The price for the second item in the order summary is incorrect.");

            checkoutPaymentsPage.clickPlaceOrderWithRetry(3);

            // Assert successful navigation to the 'Success' page.
            Assert.assertTrue(checkoutSuccessPage.isOnSuccessPage(),
                    "The navigation to the 'Success' page was NOT successful.");

            // Assert successful purchase!
            Assert.assertEquals(checkoutSuccessPage.getSuccessfulPurchaseMessage(), "Thank you for your purchase!",
                    "The successful purchase message does NOT match the expected message.");

            //Assert 'Print receipt' link is present on the Order Success Page.
            Assert.assertEquals(checkoutSuccessPage.confirmPrintReceiptLinkPresent(), "Print receipt",
                    "'Print receipt' link is NOT present on the Order Success Page.");

            //Assert 'Continue Shopping' button is present on the Order Success Page
            Assert.assertEquals(checkoutSuccessPage.confirmContinueButtonPresent(), "Continue Shopping",
                    "'Continue Shopping' button is NOT present on Order Success Page");
    }
}