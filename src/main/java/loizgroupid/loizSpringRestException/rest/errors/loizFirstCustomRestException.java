package loizgroupid.loizSpringRestException.rest.errors;

import org.springframework.http.HttpStatus ;

public class loizFirstCustomRestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int codeErreurWeb ;
	private String strLogPhrase ;


	public loizFirstCustomRestException() {
		super();
	}

	/*public loizFirstCustomRestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}*/
	public int getCodeErreurWeb() {
		return codeErreurWeb;
	}
	public void setCodeErreurWeb(int codeErreurWeb) {
		this.codeErreurWeb = codeErreurWeb;
	}
	public String getStrLogPhrase() {
		return strLogPhrase;
	}
	public void setStrLogPhrase(String strLogPhrase) {
		this.strLogPhrase = strLogPhrase;
	}


}
