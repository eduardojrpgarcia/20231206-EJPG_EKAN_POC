package ejpg.ekan.poc.web.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
	
	@JsonProperty("error_code")
	private Integer errorCode;
	
	@JsonProperty("error_message")
	private String errorMessage;

	public Integer getErrorCode() {
		return errorCode;
	}
	
	public ErrorInfo setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
		return this;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public ErrorInfo setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

}
