package Pages;

import Managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    public MainPage(PageManager pages){super(pages);}

    @FindBy(xpath = "(//a[@title='Sign In'])[2]")
    WebElement signIN;

    public void signInButtonClick(){
       signIN.click();
    }
}
