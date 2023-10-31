package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		AddPlace pal= new AddPlace();
		pal.setAccuracy(50);
		pal.setName(name);
		pal.setPhone_number("(+91)1234567890");
		pal.setAddress(address);
		pal.setWebsite("www.google.com");
		pal.setLanguage(language);
		///////////create location class object to pass the class in this set method
		Location loc=new Location();
		loc.setLat(-38.38);
		loc.setLng(33.42);
		
		pal.setLocation(loc);
		
		//////////// list of string
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		pal.setTypes(myList);
		
		return pal;
	}
	
	public String deleteplacePayLoad(String place_id) {	
	return"{\r\n"
			+ "    \"place_id\": \""+place_id+"\"\r\n"
			+ "    }";
	}

}
