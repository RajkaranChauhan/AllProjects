package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeDeletePlaceScenario() throws IOException
	{
		
		PlaceValidation placeValidation = new PlaceValidation();
		if(placeValidation.place_id==null)
		{
		placeValidation.add_place_payload_with("Raj", "Hindi", "Guwahati");
		placeValidation.user_calls_with_http_request("addPlaceAPI", "POST");
		placeValidation.verify_place_id_created_maps_to_using("Raj", "getPlaceAPI" ); ///this step is required so that the place id is created for delete post
		}
	}
	

}
