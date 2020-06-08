package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "/Fieldseeker_Office/src/test/java/features",
		tags= "@FSOS1, @FSOS2,@FSOS3,@Task2",
		glue= {"/Fieldseeker_Office/src/test/java/SeleniumGlueCode"},
		
		monochrome = true
)


public class testRunner 
{

	
}