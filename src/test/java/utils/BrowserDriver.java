package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserDriver {

    public static WebDriver driver;


    public static void getDriver(Browsers browsers) {
        if (driver == null) {
            if(browsers.equals(Browsers.CHROME))
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browsers.equals(Browsers.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Tarayıcı geçersiz! Desteklenen tarayıcılar: Chrome, Firefox");
        }
        driver.manage().window().maximize();
    }
    public static void driverQuit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
