package runner;

import org.testng.annotations.*;

public class GlobalTestSetup {

    @Parameters("browser")
    @BeforeTest
    public void setUpSuite(String browserParam) {
        System.out.println("Setting browser property to: " + browserParam);
        System.setProperty("browser", browserParam);
    }

    @AfterTest
    public void tearDownSuite() {

    }
}
