package io.curd.student;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException{
	
	
	
	private static final long serialVersionUID=1L;
	private String errorCode;
	private String errorMeaasge;
	public String getErrorCode(){
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode=errorCode;
	}
	public String getErrorMessage() {
		return errorMeaasge;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMeaasge=errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmptyInputException(String errorCode,String errorMessage) {
		super();
		this.errorCode=errorCode;
		this.errorMeaasge=errorMessage;
	}
	
	public EmptyInputException() {
		
	}
}
