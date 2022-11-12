package com.stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endPoints.EndPoints;
import com.globals.GlobalDatas;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {

	Response response;
	static GlobalDatas globaldatas = new GlobalDatas();
	
	@Given("User Add Header")
	public void userAddHeader() {
		addHeader("Accept", "application/json");
		
	}

	@When("User Add Basic Authentication for login")
	public void userAddBasicAuthenticationForLogin() throws IOException {
		basicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
		
	}

	@When("User Send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String type) {
		response = requestType(type, EndPoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		getResBodyAsPrettyString(response);
		globaldatas.setStatuscode(statusCode);
	}

	
	@Then("User verify the login response body First Name present as {string} and get the logtoken saved")
	public void userVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirstName) {
		Login_Output_Pojo login_Output_Pojo= response.as(Login_Output_Pojo.class);
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globaldatas.setLogtoken(logtoken);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("Verify first name in login endpoint", expFirstName,first_name);
	}




}
