package loizgroupid.loizSpringRestException.rest.errors;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/*
----------------------- le json d'erreur spring rest de base est :
 {
    "timestamp": "2020-04-15T16:36:22.666+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "No message available",
    "trace": "....",
    "path": "/loizSpringRestExceptionFormation/hellobeans/helloKO_CUSTSECOND"
}

------------------------et avec ce bean de type  DefaultErr.
    "timestamp": "2020-04-15T20:30:07.882+0000",
    "status": "500",
    "trace": "...",
    "locale": "fr_FR",
    "cause": "No message available"
}
 */


//@Component
//public class MyCustomErrorAttributes extends DefaultErrorAttributes {
//
//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
//        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
//        // "trace",    "path", "timestamp", "Erreur identifiée", "cause", "Code Erreur HTTP", "langue locale"
//    	Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//    	Date objDate1 = tzCal.getTime() ;    	
//    	java.sql.Timestamp sq = new java.sql.Timestamp(objDate1.getTime()); 
//    	String str = sq.toString();
//    	errorAttributes.remove("timestamp");
//    	errorAttributes.put("timestamp", str);
//        
//        errorAttributes.put("Erreur identifiée", String.valueOf(errorAttributes.get("error")));
//        errorAttributes.remove("error") ;
//        errorAttributes.put("cause", String.valueOf(errorAttributes.get("message")));
//        errorAttributes.remove("message");
//        errorAttributes.put("Code Erreur HTTP", String.valueOf(errorAttributes.get("status")));
//        errorAttributes.remove("status");
//        errorAttributes.put("langue locale", webRequest.getLocale().toString());
//        return errorAttributes;
//    }
//}