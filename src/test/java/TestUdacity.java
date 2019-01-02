import Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestUdacity extends TestBase {

    @Test(description = "Check user data")
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
