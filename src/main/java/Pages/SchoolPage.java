package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SchoolPage extends Page {

    public SchoolPage(PageManager pages){super(pages);}

    @FindBy(xpath = "(//section/div//h1)[1]")
    private WebElement firstSchool;

    @FindBy(xpath = "//a[@href='/school-of-programming']")
    private WebElement learnMoreButton;

    @FindBy(xpath = "//h1[@class='header__title h1']")
    private WebElement nameIntoSchool;

    @FindBy(xpath = "//div[@class='card-explore']")
    private WebElement cardExplore;

    @Step("Get first school name")
    public String getSchoolName(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", cardExplore);
        return wait.until(ExpectedConditions.elementToBeClickable(firstSchool)).getText();
    }

    @Step("Click learn more button")
    public void clickLearnMoreButton(){
        wait.until(ExpectedConditions.elementToBeClickable(learnMoreButton)).click();
    }

    @Step("Get name after open school")
    public String getNameIntoSchool(){
        return wait.until(ExpectedConditions.visibilityOf(nameIntoSchool)).getText();
    }


}
