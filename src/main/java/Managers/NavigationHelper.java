package Managers;

public class NavigationHelper extends PageManager {

    NavigationHelper(AppManager manager){super(manager.getDriver());}

    public void goToLoginForm(){
        mainPage.signInButtonClick();
    }

    public void goToAccountData(){
        homePage.settingsButtonClick();
    }

    public void goToCourse(){
        homePage.catalogButtonClick();
    }

    public void searchCourseAs(){
        coursePage.searchCourse();
    }

    public void openCourseAs(){
        coursePage.openCourse();
    }

    public void openOtherCourse(){
        coursePage.openOtherCourse();
    }

    public void openDetails(){
        coursePage.detailsClick();
    }

    public void goToLogout(){
        coursePage.myClassroomButtonClick();
    }

    public void closeAds(){
        coursePage.closeAdvertisement();
    }

    public String getCurrentUrl(){
       return coursePage.getCurrentUrl();
    }

    public void logout(){
        homePage.logoutButtonClick();
    }

    public void saveButton(){accountPage.clickSaveButton();}

    public void homeButton(){homePage.clickHomeButton();}

    public void openSchoolPage(){coursePage.openSchoolPage();}

    public void openLearnMoreSchool(){schoolPage.clickLearnMoreButton();}

}
