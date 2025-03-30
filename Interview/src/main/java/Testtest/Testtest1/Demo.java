package Testtest.Testtest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class Demo {

	
	
	
	public static void main(String[] args) {

	/*	String str="reverse the characters";
		
		String[] text = str.split(" ");
		String reverse="";
		int size= text.length;
		
		for (int i=size-1;i>=0;i--)
		{
			//String a=text[i];
			//reverse=reverse+" "+a;
			reverse=reverse+" "+text[i];
		}
		System.out.println(reverse);
	
	*/
		
	/*	String name="Rajkaran";
		String reverse="";
		int size=name.length();
		for (int i=size-1; i>=0;i--)
		{
		char 	rev=name.charAt(i);
		reverse=reverse+rev;
		}
		System.out.println(reverse);
	*/	
	//JsonPath p=new JsonPath("");
		
	/*	String str="reverse the characters";
		
		String[] stri = str.split(" ");
		
		List<String> string = Arrays.asList(stri);
		ArrayList<String> test=new ArrayList<String>(string);
		
	//	List<String> reverse=new ArrayList<String>();
		
		String reverse= "";
		
		int size=test.size();
		
		for (int i=size-1;i>=0;i--)
		{
			System.out.println(test.get(i));
			
			reverse= reverse+ " " +test.get(i);
		}
		
		System.out.println(reverse);

	}

}

*/
	/*
	JsonPath js= new JsonPath("{\r\n"
			+ "	  \"user1\" : {\r\n"
			+ "	     \"name\" : \"gourav\",\r\n"
			+ "	     \"password\" : \"password1\",\r\n"
			+ "	     \"profession\" : \"officer\",\r\n"
			+ "	     \"id\": 1\r\n"
			+ "	  },\r\n"
			+ "	  \"user2\" : {\r\n"
			+ "	     \"name\" : \"nikhil\",\r\n"
			+ "	     \"password\" : \"password2\",\r\n"
			+ "	     \"profession\" : \"teacher\",\r\n"
			+ "	     \"id\": 2\r\n"
			+ "	  }\r\n"
			+ "	}");
	
	String a=js.getString("user1.name");
	System.out.println(a);
	
	
/*
{
	  "user1" : {
	     "name" : "gourav",
	     "password" : "password1",
	     "profession" : "officer",
	     "id": 1
	  },
	  "user2" : {
	     "name" : "nikhil",
	     "password" : "password2",
	     "profession" : "teacher",
	     "id": 2
	  }
	}
*/
/*	
	Json
	
String name;
String password;
String profession;
int id;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getProfession() {
	return profession;
}
public void setProfession(String profession) {
	this.profession = profession;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

*/
	}
}