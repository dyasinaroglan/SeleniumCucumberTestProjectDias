package stepDefinition;

import io.cucumber.java.en.And;
import pages.FilterPage;
import utils.BrowserDriver;

public class FilterSteps {

    FilterPage filterPage;

    @And("Scroll the apple from the filter area and click the checkbox")
    public void scrollTheAppleFromTheFilterAreaAndClickTheCheckbox() {
        filterPage = new FilterPage(BrowserDriver.driver);
        filterPage.appleScrollAndCheckboxClick();
    }

    @And("Scroll to screen size and select screen size")
    public void scrollToScreenSizeAndSelectScreenSize() {
        filterPage.inc133();
    }
}
