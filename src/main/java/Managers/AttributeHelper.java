package Managers;

import java.util.List;

public class AttributeHelper extends PageManager {

    AttributeHelper(AppManager manager){super(manager.getDriver());}

    public String getResult(){return coursePage.checkResult();}

    public String getNameCourseAs(){return coursePage.getNameCourse();}

    public String getNameIntoCourse(){return coursePage.getNameIntoCourse();}

    public String checkButton(){return coursePage.learnMoreButton();}

    public void waitAllCourse(){
        coursePage.getForAllElem();
    }

    public String getSchoolName(){return schoolPage.getSchoolName();}

    public String getNameIntoSchool(){return schoolPage.getNameIntoSchool();}

    public String getUserName(){return careerPage.getUserName();}

    public List<String> ourList(){return mainPage.expectedList();}

    public List<String> getListExplore(){ return mainPage.listIntoExploreMenu();}

    public List<String> getListCareer(){return  mainPage.listIntoCareer();}

    public List<String> getOurFirstList() {return  mainPage.expecteList();}
}
