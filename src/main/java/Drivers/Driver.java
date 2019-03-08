package Drivers;

import Utils.PropertyLoader;
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



        if (Boolean.parseBoolean(PropertyLoader.loadProperty("headless"))){
            optionsChrome.addArguments("--headless");
            optionsChrome.addArguments("--no-sandbox");
            optionsChrome.addArguments("--disable-gpu");
            optionsChrome.addArguments(PropertyLoader.loadProperty("size"));
            optionsChrome.addArguments("--allow-insecure-localhost");

    }else {
            optionsChrome.addArguments("--disable-gpu");
            optionsChrome.addArguments(PropertyLoader.loadProperty("size"));
            optionsChrome.addArguments("--allow-insecure-localhost");
        }
        return new ChromeDriver(serviceChrome,optionsChrome);
    }
}
