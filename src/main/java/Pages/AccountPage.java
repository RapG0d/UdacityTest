package Pages;

import Managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends Page {

    public AccountPage(PageManager pages){super(pages);}

    @FindBy(xpath = "//input[1]")
    private WebElement nameField;

    @FindBy(xpath = "//input[2]")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[3]")
    private WebElement emailField;



    public String getName(){
        wait.until(ExpectedConditions.visibilityOf(nameField));
        return nameField.getAttribute("value");
    }

    public String getLastName(){
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        return lastNameField.getAttribute("value");
    }

    public String getEmail(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.getAttribute("value");
    }
}
