package runner;



import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"utils", "stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:cucumber.json"}
        )

public class TestRunner extends AbstractTestNGCucumberTests{

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
