package ApiTest1;

import io.restassured.RestAssured;
import pojoSerialization.AddPlace;
import pojoSerialization.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class PojoSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddPlace pal= new AddPlace();
		pal.setAccuracy(50);
		pal.setName("Frontline house");
		pal.setPhone_number("(+91)1234567890");
		pal.setAddress("29 side layout cohen09");
		pal.setWebsite("www.google.com");
		pal.setLanguage("French_IN");
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

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().queryParam("key","qaclick123")
		.body(pal)
		.when()
		.post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
	}

}
