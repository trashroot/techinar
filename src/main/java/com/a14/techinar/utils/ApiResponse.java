package com.a14.techinar.utils;

public class ApiResponse implements IResponse{
	
	private ResponseStatus status;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Object data;
	
	public ApiResponse() {
		
	}
	
	public ApiResponse(ResponseStatus status, String msg) {
		this.status = status;
		this.message = msg;
	}

	public ApiResponse(ResponseStatus status, String msg, Object data) {
		this.status = status;
		this.message = msg;
		this.data = data;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}	
	
}

