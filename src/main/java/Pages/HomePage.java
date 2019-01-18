package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HomePage extends Page {

    public HomePage(PageManager pages){super(pages);}

    @FindBy(xpath = "//a[@title='Settings']")
    private WebElement settings;

    @FindBy(xpath = "//a[@title='Catalog']")
    private WebElement catalog;

    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement logout;
    @Step("Open settings")
    public void settingsButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(settings));
        settings.click();
    }
    @Step("Open catalog and close first window")
    public void catalogButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(catalog));
        String oldTab = driver.getWindowHandle();
        catalog.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(oldTab);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    @Step("Go to logout")
    public void logoutButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }
}
