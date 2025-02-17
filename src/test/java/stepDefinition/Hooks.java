package stepDefinition;

import io.cucumber.java.After;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.BrowserDriver;
import utils.Browsers;

public class Hooks {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String br){

        if (br.equalsIgnoreCase("FIREFOX")){
            BrowserDriver.getDriver(Browsers.FIREFOX);
        } else {
            BrowserDriver.getDriver(Browsers.CHROME);
        }
    }
    @After
    public void tearDown(){
        BrowserDriver.driverQuit();
    }
}
