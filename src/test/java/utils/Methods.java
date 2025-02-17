package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ProductsPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Methods {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(Methods.class);
    public String tempData;

    public Methods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void goToUrl(String url) {
        driver.get(url);
        logger.info(url + " Sitesine gidildi.");
    }

    public void clickTo(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        logger.info("Elemente tıklandı. " + element);
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
        logger.info("element input alanına " + text + " değeri yazıldı.");

    }

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element görünür olana kadar beklenildi. " + locator);

    }

    public void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }

    public void saveElementTempData(By locator) {
        waitForElementVisible(locator);
        tempData = driver.findElement(locator).getText();

    }

    public void scrollTo(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void javascriptclicker(By element) {
        WebElement locator = driver.findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", locator);
        // click() metodu arguments[0] ifadesine ait elemente tıklama işlemini gerçekleştirir.
    }

    public void actionsClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        logger.info("Elementin üzerine gelindi.");
    }

    public WebElement clickHighestPricedProduct(By locator) {

        List<WebElement> priceElements = driver.findElements(locator);

        WebElement maxPriceElement = null;
        double maxPriceVal = 0;

        for (WebElement priceEl : priceElements) {
            String priceText = priceEl.getText().trim();
            priceText = priceText
                    .replace(".", "")
                    .replace(",", ".")
                    .replace(" TL", "");


            double currentPrice = Double.parseDouble(priceText);
            logger.info("price text : " + priceText);

            if (currentPrice > maxPriceVal) {
                maxPriceVal = currentPrice;
                maxPriceElement = priceEl;
            }
        }
        logger.info("maxPrice : " + maxPriceElement);
        return maxPriceElement;

    }

    public void clickMaxPrice(By priceLocator) {
        WebElement maxElement = clickHighestPricedProduct(priceLocator);
        Actions actions = new Actions(driver);
        if (maxElement != null) {
            logger.info("max element : " + maxElement);
            actions.moveToElement(maxElement).click().perform();
        }
    }

    public void FocusLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        logger.info("En son açılan sekmeye odaklanıldı.");
    }

    public void saveText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = element.getText().trim();
        tempData = text;
        logger.info("Elementin text değeri tempData değerine kaydedildi : " + tempData);

    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public boolean retryingFindClick(By locator) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(locator).click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }
    public void compareTextsEquals(By locator) {
        String text1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        logger.info("TempData: " + tempData);
        logger.info("Text1: " + text1);
        Assert.assertEquals("Hata mesaji - Değerler eşit değil!", tempData, text1);
        logger.info(locator + " elementinin text icerigi bellekte tutulan deger ile ayni\n" + "Bellekte tutulan deger : " + tempData + "\n" + "Elementin text icerigi : " + text1);
    }
}
