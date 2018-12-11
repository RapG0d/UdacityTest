import Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseTest extends TestBase {

    @Test
    public void checkCourseName(){
        app.getNavigationHelper().goToCourse();
        app.getAttributeHelper().waitAllCourse();
        app.getNavigationHelper().searchCourseAs();

        String resultSearch = app.getAttributeHelper().getResult();
        Assert.assertEquals(resultSearch,"Android");

        String nameCourse = app.getAttributeHelper().getNameCourseAs();
        Assert.assertTrue(nameCourse.contains("Android"));

        app.getNavigationHelper().openCourseAs();
        Assert.assertTrue(app.getAttributeHelper().getNameIntoCourse().contains(nameCourse));

        app.getNavigationHelper().goToLogout();
    }
}
