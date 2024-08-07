package showRunner.pkg;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/",
		glue="stepDefinition",
		tags="@Sanity",
		//plugin= {"pretty","html:target/cucumber-reports/report1.html"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)

public class RunnerClass extends AbstractTestNGCucumberTests {
	
	@Test
	public void TC1() {
		
	}
	
}
