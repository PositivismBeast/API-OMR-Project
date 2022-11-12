package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="", 
features = "src\\test\\resources", 
glue = "com.stepDefinition",
plugin= {"pretty","json:target\\Output.json"},dryRun=false,publish=true,
snippets=SnippetType.CAMELCASE,monochrome=true,stepNotifications=true)

public class TestRunner extends BaseClass {

	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectLoc()+ getPropertyFileValue("jsonpath"));
	
	}
}
