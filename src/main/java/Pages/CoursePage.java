package Pages;


import Managers.PageManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CoursePage extends  Page {

    public CoursePage(PageManager pages){super(pages);}


    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='filters ng-star-inserted']")
    private WebElement getResult;

    @FindBy(xpath = "(//a[@title='My Classroom'])[2]")
    private WebElement myClassroomButton;

    @FindBy(xpath = "(//h3[@class='card-heading']/a)[1]")
    private WebElement getFirstCourse;

    @FindBy(xpath = "//h1")
    private WebElement getMainName;

    @FindBy(xpath = "(//div/span[@class='ng-star-inserted'])[1]")
    private WebElement details;

    @FindBy(xpath = "(//a[@class='button--primary btn'])[1]")
    private WebElement getLearnMoreButton;

    @FindBy(xpath = "//*[@class='modal-close white-shadow']")
    private WebElement closeAdvertising;

    public void getForAllElem(){

        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='card-content']"),10));
            List<WebElement> listOfNames = driver.findElements(By.xpath("//div[@class='card-content']//a"));
            wait.until(ExpectedConditions.elementToBeClickable(listOfNames.get(0)));
            System.out.println(listOfNames.get(0).getText());
        }catch (StaleElementReferenceException e){
            getForAllElem();
        }
    }


    public void searchCourse() {
       wait.until(ExpectedConditions.elementToBeClickable(searchField));
       searchField.sendKeys("Android");
    }

    public String checkResult(){
        wait.until(ExpectedConditions.visibilityOf(getResult));
        return getResult.getText();
    }

    public String getNameCourse(){
        wait.until(ExpectedConditions.visibilityOf(getFirstCourse));
        return getFirstCourse.getText();
    }

    public String getNameIntoCourse(){
        wait.until(ExpectedConditions.visibilityOf(getMainName));
        return getMainName.getText();
    }

    public void myClassroomButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(myClassroomButton));
        myClassroomButton.click();
    }

    public void openCourse(){
        wait.until(ExpectedConditions.elementToBeClickable(getFirstCourse));
        getFirstCourse.click();
    }

    public void detailsClick(){
        wait.until(ExpectedConditions.elementToBeClickable(details));
        details.click();
    }

    public String learnMoreButton(){
        wait.until(ExpectedConditions.elementToBeClickable(getLearnMoreButton));
        return getLearnMoreButton.getText();

    }

    public void closeSupernatantWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(closeAdvertising));
        closeAdvertising.click();
    }

}
