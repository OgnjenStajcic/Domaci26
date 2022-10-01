package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private By checkoutBtn = By.name("checkout");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getCheckoutBtn() {
        return getDriver().findElement(checkoutBtn);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    public WebElement getPostalCode() {
        return getDriver().findElement(postalCode);
    }

    public WebElement getContinueBtn() {
        return getDriver().findElement(continueBtn);
    }

    public void checkout(){
        getCheckoutBtn().click();
    }

    public void form(String firstName, String lastName, String postalCode){
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPostalCode().sendKeys(postalCode);
        getContinueBtn().click();
    }

}
