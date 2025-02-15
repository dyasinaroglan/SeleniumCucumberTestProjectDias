package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserDriver;

public class Hooks {

    @Before
    public void setUp(){

        BrowserDriver.getDriver();
    }
    @After
    public void tearDown(){
        BrowserDriver.driverQuit();
    }
}
