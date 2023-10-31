package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resource\\appFeatures"},
		plugin = "json:target/cucumber-report/cucumber.json",//"json:target/jsonReports/cucumber-report.json",
	//			plugin = {
	//			        "pretty",
	//			        "json:target/cucumber-report/cucumber.json",
	//			        "html:target/cucumber-report/cucumber.html"
	//			},
		glue= {"stepDefinations"}//,
	//	tags=("@DeletePlace")
				)
public class TestRunner {
	

}
