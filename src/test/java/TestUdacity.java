import Utils.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestUdacity extends TestBase {

    @Test
    public void checkInfo(){


        app.getUserHelper().accountAs(app.getUser());
        Assert.assertEquals(app.getUser().getName(),"Mike");

        Assert.assertEquals(app.getUser().getLastName(),"Lebowski");

        Assert.assertEquals(app.getUser().getLogin(),"testmailforus9@gmail.com");









        /*
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement Settings = driver.findElement(By.xpath("//span[@title='Settings']"));
        wait.until(ExpectedConditions.elementToBeClickable(Settings));
        Settings.click();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException ie){}

        WebElement Name = driver.findElement(By.xpath("//input[@value='Mike']"));
        String strngName = Name.getAttribute("value");
        Assert.assertEquals("Mike",strngName);

        WebElement SecondName = driver.findElement(By.xpath("//input[@value='Lebowski']"));
        String strngSecondName = SecondName.getAttribute("value");
        Assert.assertEquals("Lebowski",strngSecondName);

        WebElement Email = driver.findElement(By.xpath("//input[@value='testmailforus9@gmail.com']"));
        String strngEmail = Email.getAttribute("value");
        Assert.assertEquals("testmailforus9@gmail.com",strngEmail);*/

    }


}
