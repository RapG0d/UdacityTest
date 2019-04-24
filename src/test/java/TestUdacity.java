import Utils.TestBase;
import Listeners.ScreenShotOnFailListener;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class TestUdacity extends TestBase {

    @Test(description = "Check user data", groups = {"profile1"})
    @Description("Check info about User")
    public void checkInfo(){

        app.getNavigationHelper().goToAccountData();

        String name = app.getUserHelper().nameAs();
        Assert.assertEquals(name,UserName());

        String lastName = app.getUserHelper().lastNameAs();
        Assert.assertEquals(lastName,"Lebowski");

        String email = app.getUserHelper().emailAs();
        Assert.assertEquals(email,"testmailforus9@gmail.com");

    }


}
