package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends Page {

    public MainPage(PageManager pages){super(pages);}



    @FindBy(xpath = "(//a[@title='Sign In'])[2]")
    private WebElement signIN;

    @FindBy(xpath = "(//button[contains(@class, 'button')])[2]")
    private WebElement careerButton;

    @FindBy(xpath = "(//div[@class='menu-item'])[5]")
    private WebElement careerPrepMenuItem;

    @FindBy(xpath = "//button[@class='button button--navigation']")
    private WebElement exploreDropDownMenu;

    @FindBy(xpath = "//div[@class='primary-menu-item']")
    private List<WebElement> listExplore;

    @FindBy(xpath = "//div[contains(@class,'career-nav')]//li")
    private List<WebElement> listCareer;

    @Step("Open login page")
    public void signInButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(signIN));
        actions.click(signIN).build().perform();
    }

    @Step("Open drop down menu")
    public void careerButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(careerButton)).click();
    }

    @Step("Open career page")
    public void careerPrepClick(){
        wait.until(ExpectedConditions.elementToBeClickable(careerPrepMenuItem)).click();
    }

    @Step("Open explore drop down menu")
    public void exploreMenuClick(){
        wait.until(ExpectedConditions.elementToBeClickable(exploreDropDownMenu)).click();
    }

    @Step("Get list from explore drop down menu")
    public List<String> listIntoExploreMenu(){

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement we:listExplore) {
            actualList.add(we.getText());
        }

        return actualList;
    }

    @Step("Get list from career drop down menu")
    public List<String> listIntoCareer(){

        ArrayList<String> actualList = new ArrayList<>();

        wait.until(ExpectedConditions.elementToBeClickable(careerPrepMenuItem));
        for (WebElement we: listCareer) {
            actualList.add(we.getText());
        }
        return actualList;
    }
}
