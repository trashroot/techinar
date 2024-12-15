package com.a14.techinar.utils;

public enum ResponseStatus {
	
	SUCCESS("success"),
	FAIL("fail");

	final String status;
	
	private ResponseStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
		
}
