package com.newt.exception;

public class OrderException extends Exception {
	
private String errorCode;
	
	public OrderException(String errorCode, String message) {
		super(errorCode);
		this.errorCode=errorCode;
	}
	
	public String getErrCode(){
		return this.errorCode;
	}
	
}
