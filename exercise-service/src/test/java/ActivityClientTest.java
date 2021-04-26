import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.saqibnisar.exercise_service.client.ActivityClient;
import org.saqibnisar.exercise_service.model.Activity;

public class ActivityClientTest {

	@Test
	public void test() {
		
		ActivityClient client = new ActivityClient();
		
		Activity act = client.get(1);
		
		System.out.println(act.getDesc());
	
		assertNotNull(act);
	}
	
	@Test
	public void test2() {
		
		ActivityClient client = new ActivityClient();
		
		List<Activity> act = client.getAllActivity();
		
		System.out.println(act);
	
		assertNotNull(act);
	}
	
//	@Test
//	public void test3() {
//		
//		ActivityClient client = new ActivityClient();
//		
//		client.delete(1);
//	}

}
