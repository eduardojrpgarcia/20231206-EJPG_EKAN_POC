package ejpg.ekan.poc.web.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
	
	@JsonProperty("code")
	private Integer code;
	
	@JsonProperty("message")
	private String message;

	public Integer getCode() {
		return code;
	}
	
	public ErrorInfo setCode(Integer code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}

	public ErrorInfo setMessage(String errorMessage) {
		this.message = errorMessage;
		return this;
	}

}
