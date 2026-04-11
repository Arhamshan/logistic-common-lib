package com.logistic.common.exception;

import lombok.Getter;

@Getter
public class CreateConsignmentException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errorCode;

	protected Exception e;

	public CreateConsignmentException(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public CreateConsignmentException(String message) {
		super(message);
	}
	
	public CreateConsignmentException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;		
	}

    public CreateConsignmentException(int errorCode, String message, Exception e) {
		super(message);
		this.errorCode = errorCode;
		this.e = e;
    }
}
