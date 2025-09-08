package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Feature",
    glue = "cucumber.stepdefs",
    plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}