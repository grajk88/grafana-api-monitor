package com.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Run_All_Tests {

	public static void main(String[] args) throws InterruptedException {

// Create object of TestNG Class
		TestNG runner = new TestNG();

// Create a list of String 
		
		List<String> suitefiles = new ArrayList<String>();

		for (int i = 0; i < 60; i++) {
			
			suitefiles.add("/Users/giridhar/eclipse-workspace-java/RestAssuredSample/testng.xml");

			runner.setTestSuites(suitefiles);

			runner.run();
			
			Thread.sleep(10000);
		}
	}
}