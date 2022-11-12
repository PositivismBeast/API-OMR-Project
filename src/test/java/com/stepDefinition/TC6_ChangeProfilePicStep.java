package com.stepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endPoints.EndPoints;
import com.pojo.profile.ChangeProfilePicture_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class TC6_ChangeProfilePicStep extends BaseClass {

	Response response;
	

	@Given("User Add Header for change profile picture")
	public void userAddHeaderForChangeProfilePicture() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globaldatas.getLogtoken());
		Header h3 = new Header("Content-Type", "multipart/form-data");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}



	@When("User add formData to insert Picture")
	public void userAddFormDataToInsertPicture() throws FileNotFoundException, IOException {
		addFormDData("profile_picture", new File(getProjectLoc()+getPropertyFileValue("profilepic")));
		
	}

	@When("User send {string} request for changeProfilePic endPoint")
	public void userSendRequestForChangeProfilePicEndPoint(String type) {
		response = requestType(type, EndPoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);
		
	}

	

	@Then("User verify the changeProfilePic response message matches {string}")
	public void userVerifyTheChangeProfilePicResponseMessageMatches(String expMessage) {
		ChangeProfilePicture_Output_Pojo changeProfilePicture_Output_Pojo = response.as(ChangeProfilePicture_Output_Pojo.class);
		String message = changeProfilePicture_Output_Pojo.getMessage();
		Assert.assertEquals("Verify profile updated succesfully",expMessage,message);
		
	}

}
