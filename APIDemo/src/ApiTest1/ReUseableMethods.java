package ApiTest1;

import io.restassured.path.json.JsonPath;

public class ReUseableMethods {
	public static JsonPath rawToJson(String res){
	
	JsonPath jp = new JsonPath(res);
	return jp;
	
	
}

}
