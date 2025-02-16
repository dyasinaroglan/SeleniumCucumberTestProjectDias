package stepDefinition;

import io.cucumber.java.en.And;
import pages.ProductsPage;
import utils.BrowserDriver;

public class ProductsSteps {

    ProductsPage productsPage;

    @And("Find the highest priced item and click on it")
    public void findTheHighestPricedItemAndClickOnIt() {
        productsPage = new ProductsPage(BrowserDriver.driver);
        productsPage.HighestPricedProductSelectAndClick();
    }

    @And("move to the next tab")
    public void moveToTheNextTab() {
        productsPage.endTabFocus();

    }

    @And("The product price is memorized before adding to cart")
    public void theProductPriceIsMemorizedBeforeAddingToCart() {
        productsPage.tempDataTextSave();
    }

    @And("Click on the Add to Cart button and click on the Go to Cart button on the screen that opens.")
    public void clickOnTheAddToCartButtonAndClickOnTheGoToCartButtonOnTheScreenThatOpens() {
        productsPage.addToCartAndGoToCartButtonClick();
    }
}
