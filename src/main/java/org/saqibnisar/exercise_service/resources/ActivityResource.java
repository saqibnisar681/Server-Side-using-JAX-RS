package org.saqibnisar.exercise_service.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.saqibnisar.exercise_service.model.Activity;
import org.saqibnisar.exercise_service.model.User;
import org.saqibnisar.exercise_service.repository.ActivityStub;


@Path("activities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActivityResource {

	private ActivityStub stub = new ActivityStub();
	
	@GET
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> getActivities(){
		
		return stub.getAllActivities();
	}
	
	@Path("{activityID}")
	@GET
	public Response getActivity(@PathParam("activityID") int activityID) {
		
		Activity act = stub.getActivity(activityID);
		
		if (act == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(act).build();
		
//		return stub.getActivity(activityID);
	} 
	
	@Path("{activityID}/user")
	@GET
	public User getActivityUser(@PathParam("activityID") int activityID) {
		
		return stub.getActivityUser(activityID);
	}
	
	@POST
	public Activity addActivity(Activity act) {
		
		return stub.addActivity(act);
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public Activity addActivity(MultivaluedMap<String, String> formParams) {
//		
//		System.out.println(formParams.getFirst("desc"));
//		System.out.println(formParams.getFirst("duration"));
//		
//		Activity act = new Activity();
//		act.setDesc(formParams.getFirst("desc"));
//		act.setId(Integer.parseInt(formParams.getFirst("duration")));
//		
//		return stub.create(act); 
//		
//	}
	
	@Path("{activityID}")
	@PUT
	public Activity updateActivity(@PathParam("activityID") int activityID,Activity act) {
		
		return stub.updateActivity(activityID,act);
		
	}
	
	
	@Path("{activityID}/user")
	@POST
	public User addActivityUser(@PathParam("activityID") int activityID,User user) {
		
		return stub.addActivityUser(activityID,user);
	}
	
	@Path("{activityID}")
	@DELETE
	public void deleteActivity(@PathParam("activityID") int activityID) {
		
		stub.deleteActivity(activityID);
	}
	
	@Path("/search")
	@GET
	public Activity searchActivity(@QueryParam("description") String desc) {
		
		
		return stub.searchActivity(desc);
	}
}
