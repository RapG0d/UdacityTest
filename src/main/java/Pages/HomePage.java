package Pages;

import Managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {

    public HomePage(PageManager pages){super(pages);}

    @FindBy(xpath = "//span[@title='Settings']")
    WebElement settings;

    @FindBy(xpath = "//span[@title='Logout']")
    WebElement Logout;

    public void settingsButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(settings));
        settings.click();
    }

    public void logoutButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(Logout));
        Logout.click();
    }
}
