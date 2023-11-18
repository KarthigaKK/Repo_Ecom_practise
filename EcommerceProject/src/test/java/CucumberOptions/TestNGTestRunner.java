package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features",
glue="StepDefinition",
monochrome=true,
dryRun=false,
plugin= {"pretty"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
