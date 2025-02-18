package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    public static BrowserDriver driver;


    @Before
    public void setup(){
        driver = new BrowserDriver();
    }
    @After
    public void tearDown(){
        driver.driverQuit();
    }
}
