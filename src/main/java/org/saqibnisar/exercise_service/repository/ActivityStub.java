package org.saqibnisar.exercise_service.repository;

import java.util.*;

import org.saqibnisar.exercise_service.model.*;

public class ActivityStub {

	private static List<Activity> activities = new ArrayList<>();

	
	static {
		
		Activity actv1 = new Activity(); 
		Activity actv2 = new Activity(); 
		User user = new User();
		User user2 = new User();
		
		user.setId(10537);
		user.setName("Saqib");
		
		actv1.setId(1);
		actv1.setDesc("Swimming");
		actv1.setDuration(50);
		actv1.setUser(user);
		
		user2.setId(362880);
		user2.setName("Mateen");
		
		actv2.setId(2);
		actv2.setDesc("Cycling");
		actv2.setDuration(10);
		actv2.setUser(user2);

		activities.add(actv1);
		activities.add(actv2);
	}
	
	public List<Activity> getAllActivities(){
		
		return activities;

	}
	
	public Activity getActivity(int activityID) {
		
		for(Activity act : activities) {
			
			if (act.getId() == activityID)
				return act;
		}
		return null;
	}
	
	public User getActivityUser(int activityID) {
		
		for(Activity act : activities) {
			 
			if (act.getId() == activityID)
				return act.getUser();
		}
		return null;
	}
	
	public Activity addActivity(Activity act) {
		
		act.setId((activities.size()+1));
		activities.add(act);
		return act;
	}	

	public User addActivityUser(int activityID,User user) {

		for(Activity act : activities) {
			 
			if (act.getId() == activityID)
				act.setUser(user);
		}
		return user;
	}

	public Activity create(Activity act) {
		act.setId(activities.size()+1);
		activities.add(act);
		return act;
	}
}
