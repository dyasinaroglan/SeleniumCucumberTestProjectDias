package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Methods;

import java.util.List;

public class ProductsPage {

    private Methods methods;

    public ProductsPage(WebDriver driver) {
        this.methods = new Methods(driver);
    }
    private By allPrice = By.cssSelector("div[data-test-id='price-current-price']");
    private By defaultPrice = By.cssSelector("div[data-test-id='default-price'] div span");
    private By addToCartButton = By.cssSelector("button[data-test-id='addToCart']");
    private By goToCartButton = By.xpath("//button[text()='Sepete git']");
    private By priceInBasket = By.cssSelector("div[class='product_price_uXU6Q']");


    public void HighestPricedProductSelectAndClick(){
        methods.waitForElementVisible(allPrice);
        methods.clickMaxPrice(allPrice);
    }
    public void endTabFocus(){
        methods.FocusLastTab();
    }
    public void tempDataTextSave(){
        methods.waitForElementVisible(defaultPrice);
        methods.saveText(defaultPrice);
    }
    public void addToCartAndGoToCartButtonClick(){
        methods.clickTo(addToCartButton);
        methods.clickTo(goToCartButton);
    }
    public void priceVerification() {
        methods.waitForElementVisible(priceInBasket);
        methods.compareTextsEquals(priceInBasket);
    }
}
