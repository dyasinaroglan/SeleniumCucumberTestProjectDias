package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {

    private static BrowserDriver browserDriver;

    @Before
    public void setup(){
        browserDriver = new BrowserDriver();
    }
    @After
    public void tearDown(){
        if(browserDriver != null) {
            browserDriver.driverQuit();
        }
    }
}
