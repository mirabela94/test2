package com.magento.softwaretestingboard.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By createAccountLink = By.xpath("(//*[contains(text(), 'Create an Account')])[1]");
    private final By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    private final By menNavigationMenuLink = By.xpath("//*[@id='ui-id-5']/span[2]");
    private final By jacketsMenProducts = By.xpath("//*[@id='ui-id-19']");
    private final By topsMensCategory = By.xpath("//*[@id='ui-id-17']/span[2]");
    private final By userAccountMenuElement = By.xpath("(//span[@class='logged-in'])[1]");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void navigateToHomePage() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
//        navigateTo("https://magento.softwaretestingboard.com/");
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    public void clickOnJackets() {
        WebElement newAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(jacketsMenProducts));
        newAccount.click();
    }

    public int getCartItemsCount() {

        // XPath pentru elementul care conține numărul de produse
        // WebElement totalItemsInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(itemsInCartTotal));

        WebElement cartNumberItem = driver.findElement(By.xpath("//span[@class='counter-number']"));
        System.out.println("aaaaa textul: " + cartNumberItem );
        String cartItemsText = cartNumberItem.getText().trim();  // Extrage textul și elimină spațiile
        System.out.println("aaaaabbbbbb textul: " + cartItemsText );
        int i = Integer.parseInt(cartItemsText);
        System.out.println("aaaaabbbbbb cccc textul: " + i );

        return Integer.parseInt(cartItemsText);  // Convertim textul în număr întreg

    }
    public void checkCartItems() {
        int cartItemsCount = getCartItemsCount();
        if (cartItemsCount > 0) {
            System.out.println("Sunt " + cartItemsCount + " produse în coș.");
        } else {
            System.out.println("Nu sunt produse în coș.");
        }
    }

    public void hoverToMenMenu() throws InterruptedException {
        Thread.sleep(500);
        WebElement menMenu = wait.until(ExpectedConditions.visibilityOfElementLocated((By) menNavigationMenuLink));
        Actions actions = new Actions(driver);
        actions.moveToElement(menMenu).perform();
    }

    public void hoverToTops() {
        WebElement topsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(topsMensCategory));
        Actions actions = new Actions(driver);
        actions.moveToElement(topsMenu).perform();
    }


    public String checkWelcomeMessageOnuSearchCountMenu() throws InterruptedException {
        Thread.sleep(500);
        WebElement userAccountMenu = wait.until(ExpectedConditions.elementToBeClickable(userAccountMenuElement));
        Thread.sleep(500);
        return userAccountMenu.getText();
    }

    private final String expectedCustomerHomePage = "https://magento.softwaretestingboard.com/";

    public boolean isOnHomePage() {
        wait.until(ExpectedConditions.urlToBe(expectedCustomerHomePage));
        String actualUrl = driver.getCurrentUrl();

        // Compare the actual URL with the expected URL
        return actualUrl.equals(expectedCustomerHomePage);
    }


}
