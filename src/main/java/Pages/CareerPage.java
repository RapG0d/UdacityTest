package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareerPage extends Page {

    public CareerPage(PageManager pages){super(pages);}

    @FindBy(xpath = "(//p[@class='white text-center underline'])[4]")
    private WebElement gitHubReview;

    @FindBy(xpath = "(//h4[@class='text-center'])[last()]")
    private WebElement userName;

    @Step("Scroll to GitHub review")
    public void gitHubReviewClick(){
        wait.until(ExpectedConditions.elementToBeClickable(gitHubReview)).click();
    }

    @Step("Get user name that left a review")
    public String getUserName(){
        return wait.until(ExpectedConditions.visibilityOf(userName)).getText();
    }
}
