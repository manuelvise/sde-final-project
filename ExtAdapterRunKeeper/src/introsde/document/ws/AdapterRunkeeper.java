package introsde.document.ws;

import introsde.document.model.Activities;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding
public interface AdapterRunkeeper {
	
	
	@WebMethod(operationName="getFitnessActivities")
    @WebResult(name="fitnessActivities") 
    public Activities getFitnessActivities(@WebParam(name="accessToken") String accessToken);
 
   }