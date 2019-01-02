package Pages;

import Managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HomePage extends Page {

    public HomePage(PageManager pages){super(pages);}

    @FindBy(xpath = "//span[@title='Settings']")
    private WebElement settings;

    @FindBy(xpath = "//span[@title='Catalog']")
    private WebElement catalog;

    @FindBy(xpath = "//span[@title='Logout']")
    private WebElement logout;

    public void settingsButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(settings));
        settings.click();
    }

    public void catalogButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(catalog));
        String oldTab = driver.getWindowHandle();
        catalog.click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        tabs.remove(oldTab);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void logoutButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }
}
