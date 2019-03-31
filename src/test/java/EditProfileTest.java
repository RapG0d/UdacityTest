import Utils.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import Listeners.ScreenShotOnFailListener;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class EditProfileTest extends TestBase {

    @Test(description = "Check edit name in user profile", groups = {"profile"})
    @Description("Check edit name in user profile")
    public void editProfile(){
        app.getNavigationHelper().goToAccountData();
        String startName = app.getUserHelper().nameAs();
        String newName = app.getUserHelper().editUserName();
        app.getNavigationHelper().saveChanges();
        app.getNavigationHelper().goToHomePage();
        app.getNavigationHelper().goToAccountData();
        Assert.assertEquals(app.getUserHelper().nameAs(), newName);
        Assert.assertNotEquals(app.getUserHelper().nameAs(),startName);
    }
}
