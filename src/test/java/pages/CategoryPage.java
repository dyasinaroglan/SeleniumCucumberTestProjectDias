package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Methods;

public class CategoryPage {

    private Methods methods;


    public CategoryPage(WebDriver driver){
        this.methods = new Methods(driver);
    }

    private By cookieAccept = By.id("onetrust-accept-btn-handler");
    private By electronicButton = By.xpath("//span[contains(@class, 'sf-MenuItems')][span[text()='Elektronik']]");

    private By tabletButton = By.xpath("//a[text()='Tablet']");


    public void goToSiteAndAcceptCookie(){
        methods.clickTo(cookieAccept);

    }
    public void electronicButtonClick() {
        methods.refresh();
        methods.actionsClick(electronicButton);

    }
    public void computerTabletButtonClick(){
        methods.actionsClick(tabletButton);

    }
}
