package ejpg.ekan.poc.web.exception;

public class RuntimeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RuntimeServiceException(Throwable e) {
		super(e);
	}
	
	public RuntimeServiceException(String message) {
		super(message);
	}
	
	public RuntimeServiceException() {
		super();
	}
	
}
