import Utils.TestBase;
import Listeners.ScreenShotOnFailListener;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenShotOnFailListener.class)

public class TestUdacity extends TestBase {

    @Test(description = "Check user data")
    @Description("Check info about User")
    public void checkInfo(){

        app.getNavigationHelper().goToAccountData();

        String name = app.getAttributeHelper().nameAs();
        Assert.assertEquals(name,"Mike");

        String lastName = app.getAttributeHelper().lastNameAs();
        Assert.assertEquals(lastName,"Lebowski");

        String email = app.getAttributeHelper().emailAs();
        Assert.assertEquals(email,"testmailforus9@gmail.com");

    }


}
