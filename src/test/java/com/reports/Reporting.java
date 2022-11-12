package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		File f = new File(getProjectLoc()+getPropertyFileValue("jvmpath"));
		Configuration config = new Configuration(f, "Api Automation Module");
		config.addClassifications("Sprint", "11234");
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Version", "104");
		config.addClassifications("OS", "Win10");
		
		List<String> jsonFiles = new ArrayList();
		jsonFiles.add(jsonFile);
		
		ReportBuilder rprt = new ReportBuilder(jsonFiles, config);
		rprt.generateReports();
		

	}

}
