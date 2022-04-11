package loizgroupid.loizSpringRestZalalndoProblem.rest.errors;

import org.springframework.http.HttpStatus ; 

public class loizFirstCustomRestException extends RuntimeException {	

	private static final long serialVersionUID = 1L;	
	
	public loizFirstCustomRestException() {
		super();
	}
	
	public loizFirstCustomRestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
