package com.logistic.common.exception;

import lombok.Getter;

@Getter
public class LogisticsException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int errorCode;

	protected Exception e;

	public LogisticsException(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public LogisticsException(String message) {
		super(message);
	}
	
	public LogisticsException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;		
	}

    public LogisticsException(int errorCode, String message, Exception e) {
		super(message);
		this.errorCode = errorCode;
		this.e = e;
    }
}
