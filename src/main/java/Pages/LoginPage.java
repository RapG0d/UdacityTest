package Pages;

import Managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

    public LoginPage(PageManager pages){super(pages);}

    @FindBy(xpath = "//input[@type='email']")
    WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'index--primary')]")
    WebElement loginButton;

    public LoginPage inputEmail(String login){
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public  void loginButtonClick(){
        loginButton.click();
    }
}
