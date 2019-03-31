package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HomePage extends Page {

    public HomePage(PageManager pages){super(pages);}

    @FindBy(xpath = "(//a[@target='_blank'])[1]")
    private WebElement mainPage;

    @FindBy(xpath = "//a[@title='Settings']")
    private WebElement settings;

    @FindBy(xpath = "(//span/span/i)[2]")
    private WebElement catalog;

    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement logout;

    @FindBy(xpath = "(//span/span/i)[1]")
    private WebElement home;

    @Step("Open settings")
    public void settingsButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
    }

    @Step("Open catalog and close first window")
    public void catalogButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(catalog));
        String oldTab = driver.getWindowHandle();
        try {
            actions.click(catalog).build().perform();
        }catch (StaleElementReferenceException e){
            driver.findElement(By.xpath("//span[@class='_nav-module--nav-item-icon-container--2gNdP'])[2]")).click();
        }

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(oldTab);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Step("Go to logout")
    public void logoutButtonClick(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(logout));
            logout.click();
        }catch (StaleElementReferenceException e){
            driver.findElement(By.xpath("//a[@title='Logout']")).click();
        }

    }

    @Step("Click home button")
    public void clickHomeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(home)).click();
    }

    @Step("Click main page button")
    public void clickMainPageButton(){
        String oldTab = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage)).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(oldTab);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
}
