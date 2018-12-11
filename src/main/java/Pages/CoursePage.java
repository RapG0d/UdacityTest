package Pages;


import Managers.PageManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLOutput;
import java.util.List;

public class CoursePage extends  Page {

    public CoursePage(PageManager pages){super(pages);}


    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchField;

    @FindBy(xpath = "//span[@class='filters ng-star-inserted']")
    WebElement result;

    @FindBy(xpath = "(//a[@title='My Classroom'])[2]")
    WebElement myClassroomButton;

    @FindBy(xpath = "(//h3[@class='card-heading']/a)[1]")
    WebElement firstCourse;

    @FindBy(xpath = "//h1")
    WebElement mainName;

    @FindBy(xpath = "(//div/span[@class='ng-star-inserted'])[1]")
    WebElement details;

    @FindBy(xpath = "(//a[@class='button--primary btn'])[1]")
    WebElement learn_moreButton;

    public void getForAllElem(){

        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='card-content']"), 230));
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
        wait.until(ExpectedConditions.visibilityOf(result));
        return result.getText();
    }

    public String getNameCourse(){
        wait.until(ExpectedConditions.visibilityOf(firstCourse));
        return firstCourse.getText();
    }

    public String getNameIntoCourse(){
        wait.until(ExpectedConditions.visibilityOf(mainName));
        return mainName.getText();
    }

    public void myClassroomButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(myClassroomButton));
        myClassroomButton.click();
    }

    public void openCourse(){
        wait.until(ExpectedConditions.elementToBeClickable(firstCourse));
        firstCourse.click();
    }

    public void detailsClick(){
        wait.until(ExpectedConditions.elementToBeClickable(details));
        details.click();
    }

    public String learnMoreButton(){
        wait.until(ExpectedConditions.elementToBeClickable(learn_moreButton));
        return learn_moreButton.getText();

    }

}
