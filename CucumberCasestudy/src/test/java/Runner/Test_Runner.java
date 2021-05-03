package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Login/Login.feature"},glue ="StudyDefintion",
dryRun=false,
monochrome=true,
strict = true,
plugin = {"html:testoutput/chaithratestNG.html","junit:testoutput/chaithratestNG.xml","json:testoutput/chaithratestNG.json"}
)
public class Test_Runner extends AbstractTestNGCucumberTests { 

}

