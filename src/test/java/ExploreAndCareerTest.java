import Utils.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import Listeners.ScreenShotOnFailListener;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(ScreenShotOnFailListener.class)

public class ExploreAndCareerTest extends TestBase {

    @Test(description = "Check 2 drop down menu and their lists", groups = "Lists")
    @Description("Check 2 drop down menu and their lists")
    public void checkExploreAndCareerList(){
        app.getNavigationHelper().openExploreDropDownMenu();
        List<String> expectedList = expectedList();
        List<String> actualList = app.getAttributeHelper().getListExplore();
        Assert.assertEquals(actualList,expectedList);
    }

    @Test(description = "Check 2 drop down menu and their lists",groups = "Lists2")
    @Description("Check 2 drop down menu and their lists")
    public void checkCareerList(){
        List<String> expectedList = expecteList();
        app.getNavigationHelper().openDropDownMenu();
        List<String> actualList = app.getAttributeHelper().getListCareer();
        Assert.assertEquals(actualList,expectedList);
    }
}
