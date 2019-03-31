package Managers;

import Models.User;

public class UserHelper extends PageManager {

    UserHelper(AppManager manager){super(manager.getDriver());}

    public  void  loginAs (User user){
        loginPage
                .inputEmail(user.getLogin())
                .inputPassword(user.getPassword())
                .loginButtonClick();
    }

    public String nameAs(){
        return accountPage.getName();
    }

    public String lastNameAs(){
        return accountPage.getLastName();
    }

    public String emailAs(){
        return accountPage.getEmail();
    }

    public String editUserName(){
        return accountPage.addNumbers();
    }

}
