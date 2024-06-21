package in.redBus6.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\PRAVEEN\\eclipse-workspace-latest\\RedBus6\\src\\test\\resources\\FeatureFiles",
                     glue = {"in.redBus6.StepDefinition","in.redBus.Hooks"},
                     dryRun = false,
                     monochrome = false
                     )
public class TestRunner {

}
