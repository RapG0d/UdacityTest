import Utils.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import Listeners.ScreenShotOnFailListener;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(ScreenShotOnFailListener.class)

public class ExploreAndCareerTest extends TestBase {

    @Test(description = "Check 2 drop down menu and their lists")
    @Description("Check 2 drop down menu and their lists")
    public void checkExploreAndCareerList(){
        app.getNavigationHelper().openExploreDropDownMenu();
        List<String> expectedList = app.getAttributeHelper().ourList();
        List<String> actualList = app.getAttributeHelper().getListExplore();
        Assert.assertEquals(actualList,expectedList);
    }

    @Test(description = "Check 2 drop down menu and their lists")
    @Description("Check 2 drop down menu and their lists")
    public void checkCareerList(){
        List<String> expectedList = app.getAttributeHelper().getOurFirstList();
        app.getNavigationHelper().openDropDownMenu();
        List<String> actualList = app.getAttributeHelper().getListCareer();
        Assert.assertEquals(actualList,expectedList);
    }
}
