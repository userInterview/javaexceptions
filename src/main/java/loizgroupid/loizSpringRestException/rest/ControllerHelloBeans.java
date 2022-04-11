package loizgroupid.loizSpringRestException.rest;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loizgroupid.loizSpringRestException.dto.pojouser;
import loizgroupid.loizSpringRestException.rest.errors.custumNoSuchBeanDefinitionException;
import loizgroupid.loizSpringRestException.rest.errors.loizFirstCustomRestException;
import loizgroupid.loizSpringRestException.rest.errors.loizSecondCustomRestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
//@RequestMapping(value = "/hellobeans")
public class ControllerHelloBeans {

	private Logger logger = LoggerFactory.getLogger(ControllerHelloBeans.class);

	@Autowired
	ConfigurableApplicationContext myACDepuisControleurRest;

	@GetMapping("/")
	public String bonjourRacine() {
		return "à la racine";
	}

	@GetMapping("/awakecustexcep")
	public String bonjourCustExecpt() {
	 custumNoSuchBeanDefinitionException objCustumNoSuchBeanDefinitionException = new custumNoSuchBeanDefinitionException("test") ;
	 throw objCustumNoSuchBeanDefinitionException ;
	}

	//Erreure 1 générée artificiellement...
	@GetMapping("/helloKO_CUSTFIRST")
	public String firstCtrlAdviceCustomized() {
		logger.info("-------------- debut reveilControlleurAdviceCustomized");
//		try {
			firstCustomException();
//			}
//		catch (loizFirstCustomRestException e ) {
//			System.out.println(e.getStrLogPhrase());
//		}

		logger.info("-------------- après reveilControlleurAdviceCustomized");

		return "Re-Bonjour à tous et à toutes FIRST";
	}

	public void firstCustomException()
	{
		String strMessage = "Première exception personnalisée" ;
		loizFirstCustomRestException objloizFirstCustomRestException = new loizFirstCustomRestException() ;
		int NoLigneErreur = objloizFirstCustomRestException.getStackTrace()[0].getLineNumber() ;
		strMessage = strMessage + "- classe concernée : "+ this.getClass().getCanonicalName()  +" - ligne : " + NoLigneErreur ;
		objloizFirstCustomRestException.setStrLogPhrase(strMessage);
		//System.out.println(strMessage);
		//objloizFirstCustomRestException = new loizFirstCustomRestException(strMessage) ;
		throw objloizFirstCustomRestException ;
	}

	public void methodCustomBeanNotExistException()
	{
		String strMessage = "Première exception personnalisée" ;
		custumNoSuchBeanDefinitionException objloizFirstCustomRestException = new custumNoSuchBeanDefinitionException("bean Absente") ;
		int NoLigneErreur = objloizFirstCustomRestException.getStackTrace()[0].getLineNumber() ;
		strMessage = strMessage + "- classe concernée : "+ this.getClass().getCanonicalName()  +" - ligne : " + NoLigneErreur ;
		objloizFirstCustomRestException.setStrLogPhrase(strMessage);
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
		logBean("beanPrototypeJacquesKO", "pojouser");
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
		logBean("beanAppu", "pojouser");
		logger.info("-------------- despues hola moucharder_second_bean");
		return "Re-Bonjour à tous et à toutes";
	}

	@GetMapping("/listerbeans")
	public String mappinglisterbeans() {
		logger.info("-------------- /listerbeans : antes moucharder_bean");
		listerBeans();
		logger.info("-------------- /listerbeans : despues moucharder_bean");
		return "les beans sont listées";
	}



	public void listerBeans() {
		String[] beanNames = myACDepuisControleurRest.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		System.out.println("\033[1mThis is a BOLD line\033[0m");

		String strTitleTabBeans = String.format("|| %-30s || %-10s || %-20s",  "\033[1mNom du bean\033[0m", "Scope du bean", "nom complet de classe");

		System.out.println(strTitleTabBeans);
		for (String beanName : beanNames) {
			String strClassBean = myACDepuisControleurRest.getBean(beanName).getClass().getName();
			if (isBeanFromMyApp(strClassBean)) {
				String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(beanName).getScope();
				String str = String.format("|| %-30s || %-10s || %-20s", beanName, strScope, strClassBean);
				System.out.println(str);
			}
		}
	}

	public boolean isBeanFromMyApp(String argStrClassBean) {
		return (argStrClassBean.indexOf("loizgroupid.loizSpringRestException") != -1);
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