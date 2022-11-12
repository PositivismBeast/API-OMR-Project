package com.stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endPoints.EndPoints;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.AddUserAddress_Input_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	String address_id;
	Response response;
	int address_idno;
	int country=101;
	@Given("User Add Header and bearer authorization for accessing Address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globaldatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo(first_name,last_name, mobile,apartment,TC1_LoginStep.globaldatas.getStateIdNum(),TC1_LoginStep.globaldatas.getCityId(),this.country,zipcode,address,address_type);
		addBody(address_Input_Pojo);
	}

	@When("User Send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);
	}

	@Then("User verify the addUserAddress response body message matches {string} and get the AddressId Saved")
	public void userVerifyTheAddUserAddressResponseBodyMessageMatchesAndGetTheAddressIdSaved(String expMessage) {
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address added successfully", expMessage, message);
		address_idno = addUserAddress_Output_Pojo.getAddress_id();
		TC1_LoginStep.globaldatas.setAddress_idno(address_idno);
		address_id = String.valueOf(address_idno);
	
		TC1_LoginStep.globaldatas.setAddress_id(address_id);

	}

	@When("User add request body for Update user address {string}, {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForUpdateUserAddressAnd(String address_id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(TC1_LoginStep.globaldatas.getAddress_id(),first_name,last_name, mobile,apartment,TC1_LoginStep.globaldatas.getStateIdNum(),TC1_LoginStep.globaldatas.getCityId(), this.country,zipcode,address,address_type);
		addBody(updateUserAddress_Input_Pojo);
	}

	@When("User Send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.UPDATEUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);
	}

	@Then("User verify the updateUserAddress response body message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseBodyMessageMatches(String expMessage) {
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = updateUserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		
		Assert.assertEquals( "Verify  Address updated successfully",expMessage, message);
//		Assert.assertEquals("Verify City name is Madurai",expMessage, message);
//		Assert.assertEquals(message, expMessage,"Verify updated added successfully");
		
	}

	@Given("User Send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);

	}

	@Then("User verify the getUserAddress response body message matches {string}")
	public void userVerifyTheGetUserAddressResponseBodyMessageMatches(String expMessage) {
		GetUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String message = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Get Address OK",expMessage, message);

	}

	@When("User add request body for deleteAddress {string}")
	public void userAddRequestBodyForDeleteAddress(String string) {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(TC1_LoginStep.globaldatas.getAddress_idno());
		addBody(deleteUserAddress_Input_Pojo);

	}

	@When("User Send {string} request for deleteAddress endpoint")
	public void userSendRequestForDeleteAddressEndpoint(String type) {
		response = requestType(type, EndPoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);

	}

	@Then("User verify the deleteAddress response body message matches {string}")
	public void userVerifyTheDeleteAddressResponseBodyMessageMatches(String expMessage) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address deleted successfully",expMessage,message);
	
	
	}

}
