package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Methods;

import java.util.List;

public class ProductsPage extends Methods {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    private By allPrice = By.cssSelector("div[data-test-id='price-current-price']");
    private By defaultPrice = By.cssSelector("div[data-test-id='default-price'] div span");
    private By addToCartButton = By.cssSelector("button[data-test-id='addToCart']");
    private By goToCartButton = By.xpath("//button[text()='Sepete git']");
    private By priceInBasket = By.cssSelector("div[class='product_price_uXU6Q']");


    public void HighestPricedProductSelectAndClick(){
        waitForElementVisible(allPrice);
        clickMaxPrice(allPrice);
    }
    public void endTabFocus(){
        FocusLastTab();
    }
    public void tempDataTextSave(){
        waitForElementVisible(defaultPrice);
        saveText(defaultPrice);
    }
    public void addToCartAndGoToCartButtonClick(){
        clickTo(addToCartButton);
        clickTo(goToCartButton);
    }
    public void priceVerification() {
        waitForElementVisible(priceInBasket);
        compareTextsEquals(priceInBasket);
    }
}
