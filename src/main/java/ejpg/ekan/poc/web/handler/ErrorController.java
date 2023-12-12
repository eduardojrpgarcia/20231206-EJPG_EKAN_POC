package ejpg.ekan.poc.web.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/error")
public class ErrorController {

	@GetMapping
	public ResponseEntity<ErrorInfo> error(HttpServletResponse s) {
		HttpStatus http = HttpStatus.valueOf(s.getStatus());
		ErrorInfo info = new ErrorInfo().setCode(http.value()).setMessage(http.getReasonPhrase());
		return new ResponseEntity<>(info, http);
	}
	
}
