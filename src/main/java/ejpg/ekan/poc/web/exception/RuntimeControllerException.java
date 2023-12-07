package ejpg.ekan.poc.web.exception;

public class RuntimeControllerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RuntimeControllerException(Throwable e) {
		super(e);
	}
	
	public RuntimeControllerException(String message) {
		super(message);
	}

}
