package Managers;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountPage accountPage;

    public  PageManager(WebDriver driver){
        this.driver = driver;
        mainPage = initElements(new MainPage(this));
        loginPage = initElements(new LoginPage(this));
        homePage = initElements(new HomePage(this));
        accountPage = initElements(new AccountPage(this));
    }

    private <T extends Page> T initElements(T page){
        PageFactory.initElements(driver,page);
        return page;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
