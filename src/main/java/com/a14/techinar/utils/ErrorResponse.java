package com.a14.techinar.utils;

public class ErrorResponse implements IResponse {

	private ResponseStatus status;

	private String message;

	public ErrorResponse() {

	}

	public ErrorResponse(ResponseStatus status, String msg) {
		this.status = status;
		this.message = msg;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
