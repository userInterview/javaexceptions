package loizgroupid.loizSpringRestException.rest.errors;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

//import loizgroupid.loizSpringRestException.dto.pojouser;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class HelloConrollerAdvice  extends ResponseEntityExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(HelloConrollerAdvice.class);


    //OK : Rendu personnalisé de type HTML et non json-
    /*@ExceptionHandler({ NoSuchBeanDefinitionException.class })
    public ResponseEntity<Object> handleBadRequestV0(final NoSuchBeanDefinitionException ex, final WebRequest request) {
    logger.info("méthode handleBadRequestV0");

        final ClientException objClientException = new ClientException(HttpStatus.BAD_REQUEST, "This should be application specific");
        return handleExceptionInternal(ex, objClientException, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }*/

	@ExceptionHandler({ custumNoSuchBeanDefinitionException.class })
    public ResponseEntity<ErrorDTO> handleBadRequestV01(final custumNoSuchBeanDefinitionException ex, final WebRequest request) {
		logger.info("méthode handleBadRequestV01");
		String nomBean = ex.getBeanName() ;
		ErrorDTO errorDTO = new ErrorDTO("Erreur : bean inéxistante : " + nomBean , "tentative d'instanciation d'une bean non définie dans ce micro-service");
		return new ResponseEntity<ErrorDTO>(errorDTO ,HttpStatus.BAD_REQUEST);
    }

	//OK : Réponse de type chaine
	/*@ExceptionHandler(value=NoSuchBeanDefinitionException.class)
    public @ResponseBody String iOExceptionHandlerV1(Exception ex){
    	logger.info("méthode iOExceptionHandlerV1");
		return "bean absente" ;
    }*/

    //ok : copie de "https://www.baeldung.com/exception-handling-for-rest-with-spring"
	// paragraphe : 4. Solution 3: @ControllerAdvice
	/*@ExceptionHandler(value = { NoSuchBeanDefinitionException.class})
      protected ResponseEntity<Object> handleConflictv2(RuntimeException ex, WebRequest request) {
	    	logger.info("méthode handleConflictv2");
	        String bodyOfResponse = "This should be application specific";
	        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }*/

	//OK : erreur au format json pure (enfin !!)
    /*@ExceptionHandler(NoSuchBeanDefinitionException.class)
    public ResponseEntity<ErrorDTO> handleConflictv3(RuntimeException ex, WebRequest request) {
    logger.info("méthode HandleConflictv3");
	BodyBuilder builder;
	builder = ResponseEntity.status(400);
	ErrorDTO errorDTO = new ErrorDTO("Erreur : bean inéxistante", "tentative d'instanciation d'une bean non définie dans ce micro-service");
	return builder.body(errorDTO);
    }*/

	//OK : erreur au format json pure
    /*@ExceptionHandler(NoSuchBeanDefinitionException.class)
    public ResponseEntity<ErrorDTO> HandleConflict_V4(RuntimeException ex, WebRequest request) {
//	BodyBuilder builder;
//	builder = ResponseEntity.status(400);
    logger.info("méthode HandleConflict_V4");
	ErrorDTO errorDTO = new ErrorDTO("Erreur : bean inéxistante", "tentative d'instanciation d'une bean non définie dans ce micro-service");
	return new ResponseEntity<ErrorDTO>(errorDTO ,HttpStatus.BAD_REQUEST);
    }*/

	/*@ExceptionHandler(value=NoSuchBeanDefinitionException.class)
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }*/



	/*@ExceptionHandler(value=NoSuchBeanDefinitionException.class)
    public @ResponseBody ResponseEntity<custumNoSuchBeanDefinitionException> handleBadRequest(final custumNoSuchBeanDefinitionException ex, final WebRequest request) {
    	ex.setCodeErreurWeb(HttpStatus.BAD_REQUEST.value());
        ResponseEntity<custumNoSuchBeanDefinitionException> objResponseEntity = new ResponseEntity<custumNoSuchBeanDefinitionException>(ex,HttpStatus.BAD_REQUEST);
        return objResponseEntity ;
    }*/




	/*@ExceptionHandler(NoSuchBeanDefinitionException.class)
    public ResponseEntity<custumNoSuchBeanDefinitionException> handleBadRequest(final custumNoSuchBeanDefinitionException ex, final WebRequest request) {
    	ex.setCodeErreurWeb(HttpStatus.BAD_REQUEST.value());
        ResponseEntity<custumNoSuchBeanDefinitionException> objResponseEntity = new ResponseEntity<custumNoSuchBeanDefinitionException>(HttpStatus.BAD_REQUEST);
        return objResponseEntity ;
    }*/


	/*@ExceptionHandler
    public  ResponseEntity<loizFirstCustomRestException> handleFirstLoizCustomBadRequest(final loizFirstCustomRestException ex, final WebRequest request) {
    	ex.setCodeErreurWeb(HttpStatus.BAD_REQUEST.value());
        ResponseEntity<loizFirstCustomRestException> objResponseEntity = new ResponseEntity<loizFirstCustomRestException>(ex,HttpStatus.BAD_REQUEST);
        return objResponseEntity ;
    }



    @ExceptionHandler
    public ResponseEntity<ClientException> handleBadRequest(final NoSuchBeanDefinitionException ex, final WebRequest request) {
        final ClientException objClientException = new ClientException(HttpStatus.BAD_REQUEST, "Cette Bean n\'éxiste pas");
        return new ResponseEntity<ClientException>(objClientException ,HttpStatus.BAD_REQUEST);
       // return handleExceptionInternal(ex, objClientException, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }*/



    /*@ExceptionHandler
    public ResponseEntity<ClientException> handleSecondLoizCustomBadRequest(final loizSecondCustomRestException ex) {
        final ClientException objClientException = new ClientException(HttpStatus.BAD_REQUEST, ex.getStrLogPhrase());
        return new ResponseEntity<ClientException>(objClientException ,HttpStatus.BAD_REQUEST);
    }*/


}