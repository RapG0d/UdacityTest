package Utils;

import Managers.AppManager;
import Managers.SingletonAppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public AppManager app = SingletonAppManager.getInstance().manager;

    @BeforeSuite
    public void init(){

    }


    @AfterSuite
    public void  tearDown(){app.getDriver().quit();}

    @BeforeMethod(onlyForGroups = {"profile","navigation","school","Courses"})
    public void login(){
            app.getNavigationHelper().goToLoginForm();
            app.getUserHelper().loginAs(app.getUser());

    }

    @AfterMethod(onlyForGroups = {"profile","navigation","school","Courses"})
    public void logout(){
        app.getNavigationHelper().logout();
    }

}
