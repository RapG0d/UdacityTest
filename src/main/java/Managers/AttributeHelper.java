package Managers;

public class AttributeHelper extends PageManager {

    AttributeHelper(AppManager manager){super(manager.getDriver());}


    public String nameAs(){
        return accountPage.getName();
    }

    public String lastNameAs(){
        return accountPage.getLastName();
    }

    public String emailAs(){
       return accountPage.getEmail();
    }

    public String getResult(){return coursePage.checkResult();}

    public String getNameCourseAs(){return coursePage.getNameCourse();}

    public String getNameIntoCourse(){return coursePage.getNameIntoCourse();}

    public String checkButton(){return coursePage.learnMoreButton();}

    public void waitAllCourse(){
        coursePage.getForAllElem();
    }

    public void editUserName(){
        accountPage.addNumbers();
    }

    public String getSchoolName(){return schoolPage.getSchoolName();}

    public String getNameIntoSchool(){return schoolPage.getNameIntoSchool();}
}
