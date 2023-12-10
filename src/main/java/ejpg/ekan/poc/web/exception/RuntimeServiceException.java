package ejpg.ekan.poc.web.exception;

import org.springframework.util.ObjectUtils;

public class RuntimeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	
	public RuntimeServiceException(RuntimeServiceExceptionType serviceExceptionType) {
		if (ObjectUtils.isEmpty(serviceExceptionType)) {
			this.message = "";
		} else {
			this.message = serviceExceptionType.getMessage();
		}
	}
	
	public RuntimeServiceException(Throwable e) {
		if (ObjectUtils.isEmpty(e)) {
			this.message = "";
		} else {
			initCause(e);
			this.message = e.getMessage();
		}
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
