package loizgroupid.loizSpringRestZalalndoProblem.rest.errors;

import java.net.URI;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

//import loizgroupid.loizSpringRestZalalndoProblem.dto.pojouser;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@ControllerAdvice
public class HelloConrollerAdviceClassic  
 extends ResponseEntityExceptionHandler
{

	private Logger logger = LoggerFactory.getLogger(HelloConrollerAdviceClassic.class);
   
	//Exploitation d'une exception prise en charge par Spring : de type HttpStatusCodeException
	//Elle catchera l'exception loizFirstCustomRestException
    @ExceptionHandler
    public ResponseEntity<ClientException> handleFirstLoizCustomBadRequest(final loizFirstCustomRestException argFirstException, final WebRequest request) {	    	    	    	
        final ClientException objClientException = new ClientException(HttpStatus.BAD_REQUEST, "erreur de type ClientException");                
        return new ResponseEntity<ClientException>(objClientException ,HttpStatus.BAD_REQUEST);
        //return handleExceptionInternal(argFirstException, argFirstException, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    //Exploitation d'une seconde exception personnalisée avec attributs supplémentaires
    @ExceptionHandler
    public ResponseEntity<Object> handleSecondLoizCustomBadRequest(final loizSecondCustomRestException argSecondException, final WebRequest request) {   	    	    	                            
      return handleExceptionInternal(argSecondException, argSecondException, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }   
  
    @ExceptionHandler(loizThirdCustomRestException.class)
    public ResponseEntity<Problem> handleDemoNotWorkingException(final loizThirdCustomRestException e, final WebRequest request) {
    	
    	String strUriSource = ((ServletWebRequest)request).getRequest().getRequestURI().toString() ;
    	
      return ResponseEntity.of(
        Optional.of(
          Problem.builder()
             .withType(URI.create(
            		 			strUriSource
            				   )
            	    )            
             .with("URI d'exécution", strUriSource)
             .with("Custom_MSG",e.getStrLogPhrase())  //message personnalisé
            .withTitle("exemple de json d'erreur de type zalando problem")
            .withDetail("Ceci est le détail de l'erreur et il exploite une exception de type zalando problem")
            .withStatus(Status.CONFLICT)
            .build()
        ));
    }

}