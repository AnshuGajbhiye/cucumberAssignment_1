package runTest;



	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			 features="classpath:features",
			 glue    ="stepDef",
			 tags    ="",
			 plugin  ={
					  "pretty",
					  "html:target/reports/htmlreport.html",
					  "json:target/json/file.json",
			 },
			 dryRun=false
			 
			)
	public class TestRun {
		
	}



