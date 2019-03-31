import Utils.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.ScreenShotOnFailListener;

@Listeners(ScreenShotOnFailListener.class)

public class SchoolTest extends TestBase {

    @Test(description = "Check name first school",groups = "school")
    @Description("Check name first school")
    public void checkSchoolName(){

        app.getNavigationHelper().goToCourse();
        app.getNavigationHelper().openSchoolPage();
        String name = app.getAttributeHelper().getSchoolName();
        app.getNavigationHelper().openLearnMoreSchool();
        Assert.assertTrue(name.contains(app.getAttributeHelper().getNameIntoSchool()));

    }

    @AfterMethod
    public void logout(){
        app.getNavigationHelper().goToLogout();
        app.getNavigationHelper().logout();
    }
}
