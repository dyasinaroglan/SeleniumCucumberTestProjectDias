package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class FilterPage {

    private Methods methods ;


    public FilterPage(WebDriver driver) {
        this.methods = new Methods(driver);
    }
    private By appleSelect = By.xpath("//a[contains(@href, '/apple-tablet-xc-3008012-b8849')]//span[text()='Apple']");
    private By inc133CheckBox = By.xpath("//span[text()='13,2 inç']/ancestor::a[contains(@href, 'filtreler=ekranboyutu')]");
    public void appleScrollAndCheckboxClick() {
        methods.waitForElementVisible(appleSelect);
        methods.clickTo(appleSelect);
        methods.refresh();

    }
    public void inc133 () {
        methods.waitForElementVisible(inc133CheckBox);
        methods.clickTo(inc133CheckBox);
        methods.refresh();
    }
}
