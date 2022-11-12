package com.stepDefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endPoints.EndPoints;
import com.pojo.address.GetStateList_Output_Pojo;
import com.pojo.address.StateList_Data;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass {

	Response response;
	@Given("User Add Header to get StateList Details")
	public void userAddHeaderToGetStateListDetails() {
		addHeader("Accept", "application/json");
		

	}

	@When("User Send {string} request for stateList endpoint")
	public void userSendRequestForStateListEndpoint(String type) {
		response = requestType(type, EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);
		
			}

	@Then("User verify the stateList response body StateName present as {string} and get the StateId Saved")
	public void userVerifyTheStateListResponseBodyStateNamePresentAsAndGetTheStateIdSaved(String expStateName) {
	
		GetStateList_Output_Pojo getStateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);
		ArrayList<StateList_Data> listState = getStateList_Output_Pojo.getData();
		for (StateList_Data eachStateList : listState) {
			String stateName = eachStateList.getName();
			if (stateName.equals("Tamil Nadu")) {
				int stateIdNum = eachStateList.getId();
				String stateId = String.valueOf(stateIdNum);
				TC1_LoginStep.globaldatas.setStateId(stateId);
				TC1_LoginStep.globaldatas.setStateIdNum(stateIdNum);
				System.out.println(stateIdNum);
//				Assert.assertEquals(stateName, "Tamil Nadu", "Verify State Name is Tamil Nadu");
				Assert.assertEquals("Verify State Name is Tamil Nadu",expStateName, stateName);
			}}
}

}
