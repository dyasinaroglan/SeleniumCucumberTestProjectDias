package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Methods;

public class CategoryPage extends Methods {

    private static final Logger logger = LoggerFactory.getLogger(CategoryPage.class);

    public CategoryPage(WebDriver driver){
        super(driver);
    }

    private String url = "https://www.hepsiburada.com/";
    private By electronicButton = By.xpath("//span[contains(@class, 'sf-MenuItems')][span[text()='Elektronik']]");
    private By computerTabletButton = By.xpath("//a[contains(text(), 'Bilgisayar/Tablet')]");

    public void goToSite(){
        logger.info("siteye gidilir." + url);
        goToUrl(url);
    }
    public void electronicButtonClick(){
        clickTo(electronicButton);
        logger.info("elementine tıklandı " + electronicButton);
    }
    public void computerTabletButtonClick(){
        waitForElementVisible(computerTabletButton);
        clickTo(computerTabletButton);
    }

}
