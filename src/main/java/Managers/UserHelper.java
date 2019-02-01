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

}
