package Pages;

import Managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends Page {

    public AccountPage(PageManager pages){super(pages);}

    @FindBy(xpath = "//input[1]")
    WebElement nameField;

    @FindBy(xpath = "//input[2]")
    WebElement lastNameField;

    @FindBy(xpath = "//input[3]")
    WebElement emailField;

    public AccountPage getName(String name){
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.getAttribute("value");
        return this;
    }

    public AccountPage getLastName(String lastName){
        lastNameField.getAttribute("value");
        return this;
    }

    public AccountPage getEmail(String email){
        emailField.getAttribute("value");
        return this;
    }
}
