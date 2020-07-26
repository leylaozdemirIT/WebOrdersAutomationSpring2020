package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\IdeaProjects\\WebOrdersAutomationSpring2020\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver");
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\IdeaProjects\\WebOrdersAutomationSpring2020\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name");
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
