import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver driver;




    @BeforeSuite(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://www.udacity.com/");

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement signIN = driver.findElement(By.xpath("(//a[@title='Sign In'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(signIN));
        signIN.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        WebElement inputlogin = driver.findElement(By.xpath("//input[@type='email']"));
        inputlogin.sendKeys("testmailforus9@gmail.com");

        WebElement inputPass = driver.findElement(By.xpath("//input[@type='password']"));
        inputPass.sendKeys("trash1010");

        WebElement submit = driver.findElement(By.xpath("//button[contains(@class, 'index--primary')]"));
        submit.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title = 'Logout']")));
        WebElement Logout = driver.findElement(By.xpath("//span[@title = 'Logout']"));
        Assert.assertTrue(Logout.isDisplayed());


    }

    @AfterMethod
    public void logout(){

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title = 'Logout']")));
        WebElement Logout = driver.findElement(By.xpath("//span[@title = 'Logout']"));
        Logout.click();

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title = 'Get Started'])[2]")));
        WebElement GetStarted = driver.findElement(By.xpath(("(//a[@title = 'Get Started'])[2]")));
        Assert.assertTrue(GetStarted.isDisplayed());
    }


}
