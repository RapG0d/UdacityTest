package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

    public LoginPage(PageManager pages){super(pages);}

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'index--primary')]")
    private WebElement loginButton;
    @Step("Write user {login}")
    public LoginPage inputEmail(String login){
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        loginField.sendKeys(login);
        return this;
    }
    @Step("Write user {password}")
    public LoginPage inputPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        return this;
    }
    @Step("Click login button")
    public  void loginButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
