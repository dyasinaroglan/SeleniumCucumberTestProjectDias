package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class FilterPage extends Methods {


    public FilterPage(WebDriver driver) {
        super(driver);
    }
    private By appleSelect = By.xpath("//a[contains(@href, '/apple-tablet-xc-3008012-b8849')]//span[text()='Apple']");
    private By inc133CheckBox = By.xpath("//span[text()='13,2 inç']/ancestor::a[contains(@href, 'filtreler=ekranboyutu')]");
    public void appleScrollAndCheckboxClick() {
        waitForElementVisible(appleSelect);
        clickTo(appleSelect);
        refresh();

    }
    public void inc133 () {
        waitForElementVisible(inc133CheckBox);
        clickTo(inc133CheckBox);
        refresh();
    }
}
