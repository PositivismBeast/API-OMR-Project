package com.stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endPoints.EndPoints;
import com.pojo.address.CityList;
import com.pojo.address.GetCityList_Input_Pojo;
import com.pojo.address.GetCityList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_GetCityIdStep extends BaseClass {

	Response response;
	int	cityId;
	@Given("User Add Header to get CityList Details")
	public void userAddHeaderToGetCityListDetails() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	@When("User add request body for add {string}")
	public void userAddRequestBodyForAdd(String string) {
		GetCityList_Input_Pojo getCityList_Input_Pojo = new GetCityList_Input_Pojo(
				TC1_LoginStep.globaldatas.getStateId());
		addBody(getCityList_Input_Pojo);

	}

	@When("User Send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String type) {
		response = requestType(type, EndPoints.CITYLIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);
		

	}

	@Then("User verify the CityList response body CityName present as {string} and get the CityId Saved")
	public void userVerifyTheCityListResponseBodyCityNamePresentAsAndGetTheCityIdSaved(String expCityName) {
		GetCityList_Output_Pojo getCityList_Output_Pojo = response.as(GetCityList_Output_Pojo.class);

       ArrayList<CityList> listCity = getCityList_Output_Pojo.getData();
     for (CityList eachCityList : listCity) {
	String cityName = eachCityList.getName();
	if (cityName.equals("Madurai")) {
	cityId = eachCityList.getId();
	String cityIdStr = String.valueOf(cityId);
	TC1_LoginStep.globaldatas.setCityIdStr(cityIdStr);
	TC1_LoginStep.globaldatas.setCityId(cityId);
	
		System.out.println("city id is:"+cityId);
		
//		Assert.assertEquals(cityName, "Madurai", "Verify City name is Madurai");
		Assert.assertEquals("Verify City name is Madurai",expCityName, cityName);
		

	}}}

	

}
