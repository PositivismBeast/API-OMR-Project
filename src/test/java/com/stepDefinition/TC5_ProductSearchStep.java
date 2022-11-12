package com.stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endPoints.EndPoints;
import com.pojo.product.ProductSearch_Output_Pojo;
import com.pojo.product.ProductSearch_Input_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_ProductSearchStep extends BaseClass {
	Response response;

	@Given("User Add Header for search product")
	public void userAddHeaderForSearchProduct() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("Accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
	}



	@When("User add request body for searchProduct {string}")
	public void userAddRequestBodyForSearchProduct(String text) {
		
		ProductSearch_Input_Pojo productSearch_Input_Pojo = new ProductSearch_Input_Pojo(text);
		addBody(productSearch_Input_Pojo);

	}

	@When("User Send {string} request for searchProduct endpoint")
	public void userSendRequestForSearchProductEndpoint(String type) {
		response = requestType(type, EndPoints.PRODUCTSEARCH);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldatas.setStatuscode(statusCode);
		
	}

	@Then("User verify the searchProduct response body message matches {string}")
	public void userVerifyTheSearchProductResponseBodyMessageMatches(String expMessage) {
		ProductSearch_Output_Pojo productSearch_Output_Pojo = response.as(ProductSearch_Output_Pojo.class);
		String message = productSearch_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Get Address OK",expMessage,message);

	}

}
