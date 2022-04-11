package loizgroupid.loizSpringRestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import loizgroupid.loizSpringRestException.dto.pojouser;

@SpringBootApplication
public class LoizartifactApplication implements ApplicationRunner {
	
	
	@Autowired
	ApplicationContext myACfromBootConfig ;

	public static void main(String[] args) {
		SpringApplication.run(LoizartifactApplication.class, args);
	}

	@Bean(name="beanPrototypeJacques")
	@Scope(value="prototype")
	public pojouser methodBeanJacques() {
		return new pojouser("jacques","Benmoussa") ;
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {		
		
		pojouser objpojouser = (pojouser) myACfromBootConfig.getBean("beanAppu") ;
		System.out.println("objpojouser >>> " + objpojouser);
		System.out.println("nom objpojouser >>> " + objpojouser.getNom());
		System.out.println("prenom objpojouser >>> " + objpojouser.getPrenom());		
		
	}

}
