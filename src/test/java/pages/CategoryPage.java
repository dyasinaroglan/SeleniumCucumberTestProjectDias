package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Methods;

public class CategoryPage extends Methods {

    public CategoryPage(WebDriver driver){
        super(driver);
    }

    private By cookieAccept = By.id("onetrust-accept-btn-handler");
    private By electronicButton = By.xpath("//span[contains(@class, 'sf-MenuItems')][span[text()='Elektronik']]");
    private By tabletButton = By.xpath("//a[text()='Tablet']");


    public void goToSiteAndAcceptCookie(){
        clickTo(cookieAccept);

    }
    public void electronicButtonClick() {
        refresh();
        retryingFindClick(electronicButton);

    }
    public void computerTabletButtonClick(){
        clickTo(tabletButton);

    }
}
