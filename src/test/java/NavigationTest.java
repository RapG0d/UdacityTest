import Utils.TestBase;
import Listeners.ScreenShotOnFailListener;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class NavigationTest extends TestBase {

    @Test(description = "Check url of Android", groups = "navigation")
    @Description("Check Url Android course")
    public void checkCourseUrl(){
        app.getNavigationHelper().goToCourse();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().searchCourseAs();

        Assert.assertEquals(app.getAttributeHelper().getResult(),"Android");

        app.getNavigationHelper().openCourseAs();

        Assert.assertEquals(app.getNavigationHelper().getCurrentUrl(),"https://www.udacity.com/course/android-developer-nanodegree-by-google--nd801");
    }

    @Test(description = "Check url of VR Foundation",groups = "navigation")
    @Description("Check Url VR Foundation course")
    public void checkUrlVRFoundation(){
        app.getNavigationHelper().goToCourse();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().openVrFoundationCorse();

        Assert.assertEquals(app.getNavigationHelper().getCurrentUrl(),"https://www.udacity.com/course/vr-foundations-nanodegree--nd105");
    }

    @Test(description = "Check url of VR mobile 360",groups = "navigation")
    @Description("Check Url VR mobile 360 course")
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
