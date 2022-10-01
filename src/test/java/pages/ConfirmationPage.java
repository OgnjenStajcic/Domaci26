package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends BasePage{

    private By finishBtn = By.id("finish");

    public ConfirmationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFinishBtn() {
        return getDriver().findElement(finishBtn);
    }

    public void clickFinish(){
        getFinishBtn().click();
    }


}
