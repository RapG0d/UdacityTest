package Managers;

import Drivers.Driver;
import Models.User;
import Utils.PropertyLoader;
import org.openqa.selenium.WebDriver;

public class AppManager {

    private NavigationHelper navigationHelper;
    private UserHelper userHelper;
    private AttributeHelper attributeHelper;
    private WebDriver driver;
    private User user;
    private String login;
    private String password;


    private String baseUrl;

    public AppManager(){
        login = PropertyLoader.loadProperty("email");
        password = PropertyLoader.loadProperty("password");
        baseUrl = PropertyLoader.loadProperty("base.url");

        user = new User(login,password);
        driver = new Driver().setupDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        navigationHelper = new NavigationHelper(this);
        userHelper = new UserHelper(this);
        attributeHelper = new AttributeHelper(this);




    }

    public AttributeHelper getAttributeHelper(){return attributeHelper;}

    public  NavigationHelper getNavigationHelper(){return navigationHelper;}

    public  UserHelper getUserHelper(){return userHelper;}

    public WebDriver getDriver(){
        return driver;
    }

    public User getUser(){ return user; }
}
