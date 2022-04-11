package loizgroupid.loizSpringRestException.rest.errors;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class custumNoSuchBeanDefinitionException extends NoSuchBeanDefinitionException {

	 private static final long serialVersionUID = 1L;
	 private int codeErreurWeb ;
	 private String strLogPhrase ;

	public custumNoSuchBeanDefinitionException(String name) {
		super(name);
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

    public String toString() {
        return "Bean Inexistant [Nom du bean =" + getBeanName() + "]";
    }

}
