package com.pojo.product;

import java.util.ArrayList;

public class ProductSearch_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<Product_Search> data;
	private String currency;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Product_Search> getData() {
		return data;
	}
	public void setData(ArrayList<Product_Search> data) {
		this.data = data;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}


}
