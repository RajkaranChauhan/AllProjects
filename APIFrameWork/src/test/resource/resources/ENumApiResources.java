package resources;

public enum ENumApiResources {
	
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;

	//if we try to put the below constructor above it throws error
	ENumApiResources(String resource) {
		this.resource=resource;
	}

	public String getResource()
	{
		return resource;
	}
	
}
