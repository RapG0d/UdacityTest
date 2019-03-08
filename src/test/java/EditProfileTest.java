import Utils.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import Listeners.ScreenShotOnFailListener;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class EditProfileTest extends TestBase {

    @Test(description = "Check edit name in user profile")
    @Description("Check edit name in user profile")
    public void editProfile(){
        app.getNavigationHelper().goToAccountData();
        String startName = app.getAttributeHelper().nameAs();
        app.getAttributeHelper().editUserName();
        app.getNavigationHelper().saveButton();
        app.getNavigationHelper().homeButton();
        app.getNavigationHelper().goToAccountData();
        Assert.assertNotEquals(startName, app.getAttributeHelper().nameAs());
    }
}
