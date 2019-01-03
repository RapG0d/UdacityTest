import Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NavigationTest extends TestBase {

    @Test(description = "Check url of Android")
    public void checkCourseUrl(){
        app.getNavigationHelper().goToCourse();
        app.getNavigationHelper().closeSupernatant();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().searchCourseAs();

        Assert.assertEquals(app.getAttributeHelper().getResult(),"Android");

        app.getNavigationHelper().openCourseAs();

        Assert.assertEquals(app.getNavigationHelper().getCurrentUrl(),"https://www.udacity.com/course/android-developer-nanodegree-by-google--nd801");
    }

    @Test(description = "Check url of VR Foundation")
    public void checkUrlVRFoundation(){
        app.getNavigationHelper().goToCourse();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().openCourseAs();

        Assert.assertEquals(app.getNavigationHelper().getCurrentUrl(),"https://www.udacity.com/course/vr-foundations-nanodegree--nd105");
    }

    @Test(description = "Check url of VR Foundation")
    public void checkUrlVRMobile(){
        app.getNavigationHelper().goToCourse();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().openOtherCourse();

        Assert.assertEquals(app.getNavigationHelper().getCurrentUrl(),"https://www.udacity.com/course/vr-mobile-360-nanodegree--nd106");
    }

    @AfterMethod
    public void logout(){
        app.getNavigationHelper().goToLogout();
        app.getNavigationHelper().logout();
    }
}
