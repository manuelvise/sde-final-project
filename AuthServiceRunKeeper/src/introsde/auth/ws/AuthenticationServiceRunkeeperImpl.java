package introsde.auth.ws;

import introsde.wrapper.model.Activities;
import introsde.wrapper.util.HttpGetRequestRK;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.jws.WebService;
//Service Implementation

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import sun.net.www.http.HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebService(endpointInterface = "introsde.document.ws.AuthenticationServiceRunkeeper", serviceName = "AuthenticationService")
public class AuthenticationServiceRunkeeperImpl implements
		AuthenticationServiceRunkeeper {

	private static final String CLIENT_ID = "834dce9fc49c42438f8c3d748983127a";
	private static final String CLIENT_SECRET = "8475dd2494004c30840b0bc778cee399";

	@Override
	public String getAuthenticationUrl(String redirectUri) {
		// TODO Auto-generated method stub
		String authorizationUrl = "https://runkeeper.com/apps/authorize?response_type=code&client_id="
				+ CLIENT_ID + "&redirect_uri=" + redirectUri;

		return authorizationUrl;
	}

	@Override
	public String getAccessToken(String authCode, String callbackUrl) {

		String accessTokenUrl = "https://runkeeper.com/apps/token?grant_type=authorization_code&code=%s&client_id=%s&client_secret=%s&redirect_uri=%s";
		final String request = String.format(accessTokenUrl, authCode,
				CLIENT_ID, CLIENT_SECRET, callbackUrl);

		String url = "https://runkeeper.com/apps/token";
		URL obj;
		StringBuffer response = null;
		Integer responseCode = null;
		try {
			obj = new URL(url);

			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");

			String parameters = "grant_type=authorization_code&code=%s&client_id=%s&client_secret=%s&redirect_uri=%s";
			final String urlParameters = String.format(authCode, CLIENT_ID,
					CLIENT_SECRET, callbackUrl);

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String accessToken = null;
		if (responseCode == 200) {
			JSONObject jsonToken = new JSONObject(response.toString());
			accessToken = (String) jsonToken.get("access_token");
		} 
		
		return accessToken;

	}

}
