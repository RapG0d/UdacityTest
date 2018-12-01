package Managers;

import Models.User;

public class UserHelper extends PageManager {

    public UserHelper(AppManager manager){super(manager.getDriver());}

    public  void  loginAs (User user){
        loginPage
                .inputEmail(user.getLogin())
                .inputPassword(user.getPassword())
                .loginButtonClick();
    }

    public void accountAs(User user){
        accountPage
                .getName(user.getName())
                .getLastName(user.getLastName())
                .getEmail(user.getLogin());
    }
}
