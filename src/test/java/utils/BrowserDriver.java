package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserDriver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();;
    public static ChromeOptions chromeOptions;
    public static FirefoxOptions firefoxOptions;
    String browserType = "chrome";

    public BrowserDriver() {

        String envBrowser = System.getProperty("browser", "");  // mvn clean test -Dbrowser=firefox
        if (!envBrowser.isEmpty()) {
            browserType = envBrowser;
        }

        switch (browserType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NUL");
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.setLogLevel(FirefoxDriverLogLevel.FATAL);
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            default:
                throw new RuntimeException("Desteklenmeyen tarayıcı: " + browserType);
        }

        getDriver().manage().window().maximize();
        getDriver().get("https://www.hepsiburada.com/");
    }
    public static WebDriver getDriver() {
        return driver.get();
    }


    public void driverQuit() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

