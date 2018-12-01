package Managers;

import Drivers.Driver;
import Models.User;
import Utils.PropertyLoader;
import org.openqa.selenium.WebDriver;

public class AppManager {

    private NavigationHelper navigationHelper;
    private UserHelper userHelper;
    private WebDriver driver;
    private User user;
    private String login;
    private String password;
    private String name;
    private String lastName;


    private String baseUrl;

    public AppManager(){
        login = PropertyLoader.loadProperty("email");
        password = PropertyLoader.loadProperty("password");
        name = PropertyLoader.loadProperty("name");
        lastName = PropertyLoader.loadProperty("lastName");
        baseUrl = PropertyLoader.loadProperty("base.url");

        user = new User(login,password,name,lastName);
        driver = new Driver().setupDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        navigationHelper = new NavigationHelper(this);
        userHelper = new UserHelper(this);



    }

    public  NavigationHelper getNavigationHelper(){return navigationHelper;}

    public  UserHelper getUserHelper(){return userHelper;}

    public WebDriver getDriver(){
        return driver;
    }

    public User getUser(){ return user; }
}
