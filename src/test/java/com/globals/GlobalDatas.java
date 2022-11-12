package com.globals;

public class GlobalDatas {
	private  int statuscode;
	private String logtoken;
	private String stateId;
	private int stateIdNum;
	private int	cityId;
	private String address_id;
	private int address_idno;
	public int getAddress_idno() {
		return address_idno;
	}

	public void setAddress_idno(int address_idno) {
		this.address_idno = address_idno;
	}

	private String cityIdStr;

	public String getCityIdStr() {
		return cityIdStr;
	}

	public void setCityIdStr(String cityIdStr) {
		this.cityIdStr = cityIdStr;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateIdNum() {
		return stateIdNum;
	}

	public void setStateIdNum(int stateIdNum) {
		this.stateIdNum = stateIdNum;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

}
