package org.saqibnisar.exercise_service.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

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

}
