package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {

    public MainPage(PageManager pages){super(pages);}

    @FindBy(xpath = "(//a[@title='Sign In'])[2]")
    private WebElement signIN;
    @Step("Open login page")
    public void signInButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(signIN));
       signIN.click();
    }
}
