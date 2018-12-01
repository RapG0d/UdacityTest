package Managers;

public class NavigationHelper extends PageManager {

    public NavigationHelper(AppManager manager){super(manager.getDriver());}

    public void goToLoginForm(){
        mainPage
                .signInButtonClick();
    }

    public void goToAccountData(){
        homePage
                .settingsButtonClick();
    }
}
