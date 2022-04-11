package loizgroupid.loizSpringRestException.rest.errors;

public class loizSecondCustomRestException extends RuntimeException {	

	private static final long serialVersionUID = 1L;
	
	private int codeErreurWeb ;
	private String strLogPhrase ;
	
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
