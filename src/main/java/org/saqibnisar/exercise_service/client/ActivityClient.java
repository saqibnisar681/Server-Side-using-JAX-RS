package org.saqibnisar.exercise_service.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.saqibnisar.exercise_service.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient() {
		
		this.client = ClientBuilder.newClient();
	}
	
	public Activity get(int id) {
		
		WebTarget target = client.target("http://localhost:8081/exercise-service/webapi/");
		
		Activity response = target.path("activities/" + id).request().get(Activity.class);
		
		return response;
	}
	
	public List<Activity> getAllActivity(){
		
		WebTarget target = client.target("http://localhost:8081/exercise-service/webapi/");

		
		List<Activity> response = target.path("activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>> () {});
		
		return response;

	}
 
	public void delete(int i) {

		WebTarget target = client.target("http://localhost:8081/exercise-service/webapi/");

		Response response = target.path("activities/" + i).request(MediaType.APPLICATION_JSON).delete();
	
		if (response.getStatus() != 200)
			throw new RuntimeException(response.getStatus() + ": there was an error on this server");
	}

}
