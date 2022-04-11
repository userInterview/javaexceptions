package loizgroupid.loizSpringRestZalalndoProblem.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

import loizgroupid.loizSpringRestZalalndoProblem.dto.pojouser;

@Configuration
public class AppConfigDeBeans {
 

//    @Bean
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper().registerModules(new ProblemModule().withStackTraces());
//    }
	
    @Bean    
	public pojouser methodBeanAppu() {
		return new pojouser("Apu","Ramiaranana") ;
	}
    


}