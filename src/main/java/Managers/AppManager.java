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


    AppManager(){
        String login = PropertyLoader.loadProperty("email");
        String password = PropertyLoader.loadProperty("password");
        String baseUrl = PropertyLoader.loadProperty("base.url");

        user = new User(login, password);
        driver = new Driver().setupDriver();
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
