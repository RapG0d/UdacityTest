package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Calendar;

public class AccountPage extends Page {

    public AccountPage(PageManager pages){super(pages);}

    @FindBy(id = "firstNameInput")
    private WebElement nameField;

    @FindBy(xpath = "(//input)[2]")
    private WebElement lastNameField;

    @FindBy(xpath = "(//input)[3]")
    private WebElement emailField;

    @FindBy(xpath = "(//span[@class='vds-button__content'])[3]")
    private WebElement saveButton;


    @Step("Get user name")
    public String getName(){
        wait.until(ExpectedConditions.visibilityOf(nameField));
        return nameField.getAttribute("value");
    }
    @Step("Get user Last name")
    public String getLastName(){
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        return lastNameField.getAttribute("value");
    }
    @Step("Get user email")
    public String getEmail(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.getAttribute("value");
    }
    @Step("Clear name field and edit this field")
    public String addNumbers(){
        wait.until(ExpectedConditions.visibilityOf(nameField));
        wait.until((ExpectedCondition<Boolean>) driver -> nameField.getAttribute("value").length() != 0);
        nameField.clear();
        int calendar = Calendar.getInstance().get(Calendar.MILLISECOND);
        wait.until(ExpectedConditions.visibilityOf(nameField));
        String name = "Mike"+calendar;
        nameField.sendKeys(name);
        return name;
    }
    @Step("Click save button")
    public void clickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
