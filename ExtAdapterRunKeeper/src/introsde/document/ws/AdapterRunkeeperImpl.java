package introsde.document.ws;

import introsde.document.model.Activities;
import introsde.document.util.HttpGetRequest;
import introsde.document.util.HttpGetRequestRK;

import java.io.IOException;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Service Implementation

@WebService(endpointInterface = "introsde.document.ws.ExtAdapterRunkeeper", serviceName = "AdapterRunkeeperService")
public class AdapterRunkeeperImpl implements AdapterRunkeeper {

	@Override
	public Activities getFitnessActivities(String accessToken) {
		
		HttpGetRequestRK activitiesRequest = new HttpGetRequestRK("https://api.runkeeper.com", "fitnessActivities", accessToken, "application/vnd.com.runkeeper.FitnessActivityFeed+json");
		String responseFromRunkeeper = activitiesRequest.getResponse();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(responseFromRunkeeper, Activities.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
