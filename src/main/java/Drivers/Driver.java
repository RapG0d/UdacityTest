package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Driver {


    public WebDriver setupDriver(){
        File chromeDriver = new File("./src/main/resources/chromedriver.exe");
        ChromeDriverService serviceChrome = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--headless");
        optionsChrome.addArguments("--disable-gpu");
        optionsChrome.addArguments("--no-sandbox");
        optionsChrome.addArguments("--window-size=2048,1152");
        optionsChrome.addArguments("--allow-insecure-localhost");
        return new ChromeDriver(serviceChrome,optionsChrome);
    }
}
