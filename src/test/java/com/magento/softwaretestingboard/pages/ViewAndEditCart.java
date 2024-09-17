package com.magento.softwaretestingboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewAndEditCart {

  private  static WebDriver driver;
  private static  WebDriverWait wait;
  private By cartItemsText = By.xpath("//span[@class='counter-number']");

    public ViewAndEditCart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public static void navigateToHomePage() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
//        navigateTo("https://magento.softwaretestingboard.com/");
    }
    public static int getCartItemsCount() {

            // XPath pentru elementul care conține numărul de produse
       // WebElement totalItemsInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(itemsInCartTotal));

        WebElement cartNumberItem = driver.findElement(By.xpath("//span[@class='counter-number']"));
            System.out.println("aaaaa textul: " + cartNumberItem );
            String cartItemsText = cartNumberItem.getText().trim();  // Extrage textul și elimină spațiile
            return Integer.parseInt(cartItemsText);  // Convertim textul în număr întreg

    }
    public static void checkCartItems() {
        int cartItemsCount = getCartItemsCount();
        if (cartItemsCount > 0) {
            System.out.println("Sunt " + cartItemsCount + " produse în coș.");
        } else {
            System.out.println("Nu sunt produse în coș.");
        }
    }



    //https://magento.softwaretestingboard.com/checkout/cart/

}
