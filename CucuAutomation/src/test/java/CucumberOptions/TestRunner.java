package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefination"
		
				)

public class TestRunner {

	
	//https://github.com/rameshkorla1/CucumberProject
}
