import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestUdacity {

    WebDriver driver;

    @Test
    public void start(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.udacity.com/");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement element = driver.findElement(By.xpath("//div [@class='modal-close']"));
        element.click();

        try {
            Thread.sleep(400);
        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
        }


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

        driver.quit();
    }


}
