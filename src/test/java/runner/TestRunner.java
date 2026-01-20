package runner;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExcelUtilities;

@CucumberOptions(
    features = "src/test/resources/features",  // path to feature files
    glue = {"stepDefinations","hooks"},                 // package containing step defs
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
  //New code push  
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
    
		return super.scenarios(); 
    }
	
}
