package MyRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "C:\\Workspace6\\CucumberTestNG\\src\\main\\java\\Features\\login.feature",
		glue = {"C:\\Workspace6\\CucumberTestNG\\src\\main\\java\\stepDefinitions\\LoginStepDefinition.java"},
		tags = {"~@Ignore"},
		format = {"pretty",
				  "html:target/cucumber-reports/cucumber-pretty",
				  "json:target/cucumber-reports/CucumberTestReport.json",
				  "rerun:target/cucumber-reports/rerun.txt"},
		plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
	
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature){
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
		
	}

}
