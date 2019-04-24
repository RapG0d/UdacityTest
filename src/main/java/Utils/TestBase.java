package Utils;

import Managers.AppManager;
import Managers.SingletonAppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class TestBase {

    public AppManager app = SingletonAppManager.getInstance().manager;

    @BeforeSuite
    public void init(){

    }


    @AfterSuite
    public void  tearDown(){app.getDriver().quit();}

    @BeforeMethod(onlyForGroups = {"profile1","profile2","navigation","school","Courses"})
    public void login(){
            app.getNavigationHelper().goToLoginForm();
            app.getUserHelper().loginAs(app.getUser());

    }

    @BeforeMethod(onlyForGroups = {"Lists"})
    public List<String> expectedList(){

        ArrayList<String> exploreList = new ArrayList<>();

        exploreList.add("PROGRAMMING AND DEVELOPMENT");
        exploreList.add("ARTIFICIAL INTELLIGENCE");
        exploreList.add("DATA SCIENCE");
        exploreList.add("AUTONOMOUS SYSTEMS");
        exploreList.add("BUSINESS");
        exploreList.add("CAREER");

        return exploreList;
    }

    @BeforeMethod(onlyForGroups = {"Lists2"})
    public List<String> expecteList(){

        ArrayList<String> exploreList = new ArrayList<>();


        exploreList.add("CAREER PREP");
        exploreList.add("GET HIRED");
        exploreList.add("HIRE OUR GRADS");

        return exploreList;
    }

    @AfterMethod(onlyForGroups = {"profile1","profile2","navigation","school","Courses"})
    public void logout(){
        app.getNavigationHelper().logout();
    }

    @AfterMethod(onlyForGroups = {"profile2"})
    public String UserName(){
        return app.getUserHelper().nameAs();
    }

}
