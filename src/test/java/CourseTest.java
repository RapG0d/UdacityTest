import Utils.TestBase;
import Listeners.ScreenShotOnFailListener;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class CourseTest extends TestBase {

    @Test(description = "Find course and check his info")
    @Description("Find course and check result search, name course and button 'Learn more'")
    public void checkCourseName(){
        app.getNavigationHelper().goToCourse();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().searchCourseAs();

        Assert.assertEquals(app.getAttributeHelper().getResult(),"Android");

        String nameCourse = app.getAttributeHelper().getNameCourseAs();
        Assert.assertTrue(nameCourse.contains("Android"));

        app.getNavigationHelper().openDetails();
        Assert.assertEquals(app.getAttributeHelper().checkButton(),"LEARN MORE");

        app.getNavigationHelper().openCourseAs();
        Assert.assertTrue(app.getAttributeHelper().getNameIntoCourse().contains(nameCourse));
    }

    @AfterMethod
    public void logout(){
        app.getNavigationHelper().goToLogout();
        app.getNavigationHelper().logout();
    }


}
