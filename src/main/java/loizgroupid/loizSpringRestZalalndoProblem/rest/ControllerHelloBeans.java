package loizgroupid.loizSpringRestZalalndoProblem.rest;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import loizgroupid.loizSpringRestZalalndoProblem.dto.pojouser;
import loizgroupid.loizSpringRestZalalndoProblem.rest.errors.loizFirstCustomRestException;
import loizgroupid.loizSpringRestZalalndoProblem.rest.errors.loizSecondCustomRestException;
import loizgroupid.loizSpringRestZalalndoProblem.rest.errors.loizThirdCustomRestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin 
//@RequestMapping(value = "/hellobeans")
public class ControllerHelloBeans {

	private Logger logger = LoggerFactory.getLogger(ControllerHelloBeans.class);	

	@Autowired
	ConfigurableApplicationContext myACDepuisControleurRest;

//	@GetMapping("/")
//	public String bonjourRacine(Exception e) {		
//		return "à la racine";
//	}
	
	 @GetMapping("/error") 
	  public ResponseEntity<Exception> bonjourGererError() {		  
	//  public String bonjourGererErreur() {
		  return loizspringerror();
		 //return "à la racine";
	}	
	 
	 @GetMapping("/") 
	  public ResponseEntity<Exception> bonjourGererErreur() {		  
	//  public String bonjourGererErreur() {
		  return loizspringerror();
		 //return "à la racine";
	}	 

	//Erreure 1 générée artificiellement...
	@GetMapping("/lookspringerror")
	public ResponseEntity<Exception> loizspringerror() {		
		logger.info("-------------- debut exception sndard artificielle") ; 
		return new ResponseEntity<Exception>(new Exception(), HttpStatus.BAD_REQUEST);
	}
	
	//Erreure 1 générée artificiellement...
	@GetMapping("/zalproblem")
	public ResponseEntity<loizThirdCustomRestException> thirdCtrlAdviceCustomized() {		
		logger.info("-------------- debut zalando problem Exception") ; 
		return thirdCustomException();
	}
	
	public ResponseEntity<loizThirdCustomRestException> thirdCustomException() 
	{
		String strMessage = "Première exception personnalisée" ; 
		loizThirdCustomRestException objloizThirdCustomRestException = new loizThirdCustomRestException() ;  
		int NoLigneErreur = objloizThirdCustomRestException.getStackTrace()[0].getLineNumber() ;
		strMessage = strMessage + "- classe concernée : "+ this.getClass().getCanonicalName()  +" - ligne : " + NoLigneErreur ;
		objloizThirdCustomRestException.setStrLogPhrase(strMessage);		
		return new ResponseEntity<loizThirdCustomRestException>(objloizThirdCustomRestException, HttpStatus.BAD_REQUEST);		
	}
	
	//Erreure 1 générée artificiellement...
	@GetMapping("/helloKO_CUSTFIRST")
	public String firstCtrlAdviceCustomized() {		
		logger.info("-------------- debut reveilControlleurAdviceCustomized");

			firstCustomException();
		
		logger.info("-------------- après reveilControlleurAdviceCustomized");
		
		return "Re-Bonjour à tous et à toutes FIRST";
	}
	
	public void firstCustomException() 
	{
		String strMessage = "Première exception personnalisée" ; 
		loizFirstCustomRestException objloizFirstCustomRestException = new loizFirstCustomRestException("erreur de type loizFirstCustomRestException") ; 
		throw objloizFirstCustomRestException ; 
	}
	
	//Erreure 2 générée artificiellement...
	@GetMapping("/helloKO_CUSTSECOND")
	public String secondControlleurAdviceCustomized()  throws loizFirstCustomRestException {		
		logger.info("-------------- debut reveilControlleurAdviceCustomized") ;		
			secondCustomException() ;

		logger.info("-------------- après reveilControlleurAdviceCustomized") ;		
		return "Re-Bonjour à tous et à toutes SECOND";
	}
	
	public void secondCustomException() throws loizSecondCustomRestException {
		throw new loizSecondCustomRestException() ;
	}
	
	//La bean suivante est absente, une erreure devrait être générée
	@GetMapping("/helloKO")
	public String reveilControlleurAdvice() {
		logger.info("-------------- debut reveilControlleurAdvice");
		logBean("beanPrototypeJacquesKO", "pojouser");
		logger.info("-------------- après reveilControlleurAdvice");
		return "Re-Bonjour à tous et à toutes";
	}
	
	@GetMapping("/hello")
	public String mappingBonjour() {
		logger.info("-------------- debut hello moucharder_bean");
		logBean("beanPrototypeJacques", "pojouser");
		logger.info("-------------- après hello moucharder_bean");
		return "Re-Bonjour à tous et à toutes";
	}

	@GetMapping("/hola")
	public String mappinghola() {
		logger.info("-------------- antes hola moucharder_second_bean");
		logBean("methodBeanAppu", "pojouser");
		logger.info("-------------- despues hola moucharder_second_bean");
		return "Re-Bonjour à tous et à toutes";
	}

	@GetMapping("/listerbeans")
	public String mappinglisterbeans() {
		logger.info("-------------- /listerbeans : antes moucharder_bean");
		String sListeBean = listerBeans();
		System.out.println(sListeBean);
		logger.info("-------------- /listerbeans : despues moucharder_bean");
		return "les beans sont listées\n" + sListeBean;
	}
	


	public String listerBeans() {
		String[] beanNames = myACDepuisControleurRest.getBeanDefinitionNames();
		Arrays.sort(beanNames);		
		String strTitleTabBeans = String.format("|| %-30s || %-10s || %-20s",  "\033[1mNom du bean\033[0m", "Scope du bean", "nom complet de classe");
		String strListeBeans  = "" ;
		System.out.println(strTitleTabBeans);
		for (String beanName : beanNames) {
			String strClassBean = myACDepuisControleurRest.getBean(beanName).getClass().getName();
			if (isBeanFromMyApp(strClassBean)) {
				String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(beanName).getScope();
				if(strListeBeans.length()== 0)
					strListeBeans = String.format("|| %-30s || %-10s || %-20s", beanName, strScope, strClassBean);
				else
					strListeBeans = strListeBeans + "\n" + String.format("|| %-30s || %-10s || %-20s", beanName, strScope, strClassBean);				
			}
		}
		return strListeBeans ;
	}

	public boolean isBeanFromMyApp(String argStrClassBean) {
		return (argStrClassBean.indexOf("loizgroupid.loizSpringRestZalalndoProblem") != -1 | 
				argStrClassBean.indexOf("com.fasterxml.jackson.databind") != -1);
	}

	public void logBean(String strNomAppBean, String libelle) {
		pojouser objpojo = (pojouser) myACDepuisControleurRest.getBean(strNomAppBean);
		logger.info("{} >>> {}", libelle, objpojo);
		logger.info("nom {} >>> {}", libelle, objpojo.getNom());
		logger.info("prenom {} >>> {}", libelle, objpojo.getPrenom());
	}

	@GetMapping("/listerinstances")
	public String mappinglisterinstances() {
		logger.info("-------------- before mappinglisterinstances");
		getInstantiatedSingletons();
		logger.info("-------------- after mappinglisterinstances");
		return "les beans de types syngleton sont listés";
	}

	// Affichage des beans liés à l'aplication et affichage de leur type public
	void getInstantiatedSingletons() {
		String[] all = myACDepuisControleurRest.getBeanDefinitionNames();
		ConfigurableListableBeanFactory clbf = ((AbstractApplicationContext) myACDepuisControleurRest).getBeanFactory();
		for (String BeanName : all) {
			String strClassBean = myACDepuisControleurRest.getBean(BeanName).getClass().getName();
			if (isBeanFromMyApp(strClassBean)) {
				Object objSing = clbf.getSingleton(BeanName);
				if (objSing != null) {
					String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(BeanName).getScope();
					logger.info("BeanName " + BeanName + " de type \"" + strScope + "\"");
				} else {
					String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(BeanName).getScope();
					logger.info("BeanName " + BeanName + "\"NON SINGLETON\" de type : \"" + strScope + "\"");
				}
			}
		}
	}

}