package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class RequestTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private ConfirmationPage confirmationPage;
    private LogOutPage logOutPage;



    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Destop PC\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, wait);
        productPage = new ProductPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        confirmationPage = new ConfirmationPage(driver, wait);
        logOutPage = new LogOutPage(driver, wait);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginTest(){
        Assert.assertTrue(loginPage.getLoginBtn().isDisplayed());
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
        loginPage.login("standard_user", "secret_sauce");
        String expectedResult = "PRODUCTS";
        WebElement actualResult = driver.findElement(By.className("title"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
    }

    @Test(priority = 2)
    public void add() throws InterruptedException {
        productPage.add();
        String expectedResult = "REMOVE";
        WebElement actualResult = driver.findElement(By.id("remove-sauce-labs-backpack"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
        productPage.inCart();
        String expectedResult2 = "1";
        WebElement actualResult2 = driver.findElement(By.className("cart_quantity"));
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void shoping() throws InterruptedException {
        Assert.assertTrue(cartPage.getCheckoutBtn().isDisplayed());
        cartPage.checkout();
        String expectedResult = "CHECKOUT: YOUR INFORMATION";
        WebElement actualResult = driver.findElement(By.className("title"));
        Assert.assertEquals(actualResult.getText(), expectedResult);
        cartPage.form("Ognjen", "Stajcic", "21000");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void confirmation() throws InterruptedException {
        String expectedResult = "Total: $32.39";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));
        Assert.assertTrue(actualResult.getText().equals(expectedResult));
        confirmationPage.clickFinish();
        String expectedResult2 = "CHECKOUT: COMPLETE!";
        WebElement actualResult2 = driver.findElement(By.className("title"));
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void logOut() throws InterruptedException {
        logOutPage.burgerClick();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logOutPage.logout();
    }

}
