package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CategoryPage;
import utils.BrowserDriver;

public class CategorySteps {

    CategoryPage categoryPage;

    @Given("user goes to")
    public void userGoesTo() {
        categoryPage = new CategoryPage(BrowserDriver.getDriver());
        categoryPage.goToSiteAndAcceptCookie();

    }

    @When("go to category")
    public void goToCategory() {
        categoryPage.electronicButtonClick();
    }

    @And("user click on the computer-tablet icon")
    public void userClickOnTheComputerTabletIcon() {
        categoryPage.computerTabletButtonClick();
    }
}
