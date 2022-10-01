package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutPage extends BasePage{

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logoutBtn = By.id("logout_sidebar_link");

    public LogOutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getBurgerMenu() {
        return getDriver().findElement(burgerMenu);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public void burgerClick(){
        getBurgerMenu().click();
    }

    public void logout(){
        getLogoutBtn().click();
    }

}
