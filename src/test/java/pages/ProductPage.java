package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage extends BasePage {

    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");

    private By cart = By.id("shopping_cart_container");

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAddToCartBtn() {
        return getDriver().findElement(addToCartBtn);
    }


    public WebElement getCart() {
        return getDriver().findElement(cart);
    }

    public void add(){
        getAddToCartBtn().click();
    }

    public void inCart(){
        getCart().click();
    }

}
