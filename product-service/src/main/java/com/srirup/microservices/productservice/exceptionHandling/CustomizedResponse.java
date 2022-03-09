package com.srirup.microservices.productservice.exceptionHandling;

import java.util.Date;

public class CustomizedResponse {
	private Date timeStamp;
	private String message;
	private String details;
	
	public CustomizedResponse(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
}
