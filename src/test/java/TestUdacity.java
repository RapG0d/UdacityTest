import Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestUdacity extends TestBase {

    @Test
    public void checkInfo(){

        String name = app.getAttributeHelper().nameAs();
        Assert.assertEquals(name,"Mike");

        String lastName = app.getAttributeHelper().lastNameAs();
        Assert.assertEquals(lastName,"Lebowski");

        String email = app.getAttributeHelper().emailAs();
        Assert.assertEquals(email,"testmailforus9@gmail.com");

    }


}
