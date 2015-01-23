package introsde.auth.endpoint;
import introsde.auth.ws.AuthenticationServiceRunkeeperImpl;

import javax.xml.ws.Endpoint;

public class AuthenticationServiceRunkeeperPublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "6903";
	public static String BASE_URL = "/ws/lifecoach/authenticationrunkeeper";
	
	public static String getEndpointURL() {
		return SERVER_URL+":"+PORT+BASE_URL;
	}
 
	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Starting Runkeeper authentication Service...");
		System.out.println("--> Published at = "+endpointUrl);
		Endpoint.publish(endpointUrl, new AuthenticationServiceRunkeeperImpl());
    }
}

