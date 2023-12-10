package ejpg.ekan.poc.web.exception;

public enum RuntimeServiceExceptionType {
	
	THE_DTO_DEPENDECY_ID_HAS_NOT_SET("The dependency id has not set"),
	THE_DTO_ID_HAS_NOT_SET("The id has not set"),
	THE_DTO_ID_HAS_SET_IN_A_CREATE_OPERATION("THE id has set in a create operation"),
	THE_ARGUMENT_IS_NULL("The argument is null");
	
	private String message;
	
	private RuntimeServiceExceptionType(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
