package com.stepDefinition;



import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep {

	@Then("User verify the statusCode is {int}")
	public void userVerifyTheStatusCodeIs(int expCode) {
		int actualCode = TC1_LoginStep.globaldatas.getStatuscode();
		Assert.assertEquals( "Verify status code",expCode,actualCode);

		
	}

}
