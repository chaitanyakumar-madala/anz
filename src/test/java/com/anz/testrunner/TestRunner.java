package com.anz.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com/anz/stepdefs", monochrome = true,
plugin= {"html:target/cucumber-html-report.html","rerun:target/rerun.txt","pretty","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
