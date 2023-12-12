package ejpg.ekan.poc.web.handler;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ejpg.ekan.poc.web.exception.RuntimeControllerException;
import ejpg.ekan.poc.web.exception.RuntimeServiceException;

@ControllerAdvice
public final class GlobalControllerExceptionHandler {
	
	private static final Logger logger = Logger.getLogger(GlobalControllerExceptionHandler.class);
	
	@ExceptionHandler(RuntimeServiceException.class)
	public ResponseEntity<ErrorInfo> runtimeServiceExceptionHandler(HttpServletRequest r, Throwable e) {
		return new ResponseEntity<>(info(r, e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeControllerException.class)
	public ResponseEntity<ErrorInfo> runtimeControllerException(HttpServletRequest r, Throwable e) {
		return new ResponseEntity<>(info(r, e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ErrorInfo> defaultExceptionHanlder(HttpServletRequest r, Throwable e) {
		return new ResponseEntity<>(info(r, e), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ErrorInfo info(HttpServletRequest r, Throwable e) {
		String pathURL = r.getRequestURL().toString();
		String error = e.getLocalizedMessage();
		logger.warn(pathURL + " : " + error);
		return null;
	}
	
}
