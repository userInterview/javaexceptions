package custom_Exceptions;

public class LoizFirstCustomException extends Throwable {	

	private static final long serialVersionUID = 1L;
	
	private int codeErreurWeb ;
	public String strLogPhrase ;
	
	
	public LoizFirstCustomException() {
		super();
	}
	
	public LoizFirstCustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
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
