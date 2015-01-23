package introsde.auth.ws;

import introsde.wrapper.model.Activities;

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
public interface AuthenticationServiceRunkeeper {
	
	
	@WebMethod(operationName="getAuthenticationUrl")
    @WebResult(name="AuthenticationUrl") 
    public String getAuthenticationUrl(@WebParam(name="redirectUri") String redirectUri);
 
	
	@WebMethod(operationName="getAccessToken")
    @WebResult(name="accessToken") 
    public String getAccessToken(@WebParam(name="authCode") String authCode, @WebParam(name="callbackUrl") String callbackUrl);
 
	
	
   }