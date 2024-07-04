package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue= "Anushacompany.stepDefinitions", monochrome=true, tags="@Regression", plugin= {"html:target/cucumber.html"})
//monochrome is used to read the report
public class TestngTestRunner extends AbstractTestNGCucumberTests{

}
