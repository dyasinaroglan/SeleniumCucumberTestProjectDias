package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {

    protected WebDriver driver;
    protected WebDriverWait wait;

    String tempData;
    public Methods(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }
    public void goToUrl(String url){
        driver.get(url);
    }
    public void clickTo(By locator){
        driver.findElement(locator).click();
        Log.info(locator + "elementine tıklandı.");

    }
    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
        Log.info("Elementine" + text + " değeri yazıldı");
    }
    public WebElement find(By locator) {
        return driver.findElement(locator);

    }
    public void waitForElementVisible(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Log.info("Element görünür olana kadar beklendi." + locator);
    }
    public boolean visibleIsDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Log.info("Elemente javaScript ile tıklandı " + locator);
    }
    public void saveElementTempData(By locator){
        waitForElementVisible(locator,5);
        tempData = driver.findElement(locator).getText();
        Log.info("element tempData değişkenine kaydedildi"  + " tempData değeri : " + tempData);

    }
    public int parseInteger(By locator){
        waitForElementVisible(locator,5);
        String elementText = driver.findElement(locator).getText();
        return Integer.parseInt(elementText.trim());
    }
}
