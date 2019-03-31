import Utils.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import Listeners.ScreenShotOnFailListener;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class CareerServicesTest extends TestBase {

    @Test(description = "Check last user that left review")
    @Description("Check last user that left review")
    public void testimonialOfGitHubReview(){
        app.getNavigationHelper().openDropDownMenu();
        app.getNavigationHelper().goToCareerServicesPage();
        app.getNavigationHelper().scrollToGitHubReview();
        Assert.assertEquals(app.getAttributeHelper().getUserName(), "Samuel R.");
    }
}
