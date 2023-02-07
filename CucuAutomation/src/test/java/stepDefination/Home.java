package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home {

	@Given("use the URL and navigate to the home page of the application")
	public void use_the_url_and_navigate_to_the_home_page_of_the_application() {
		System.out.println("Navigated to home page");
	}
	
	@When("user login with credentials using username {string} and password {string}")
	public void user_login_with_credentials_using_username_and_password(String username, String Password) {
		System.out.println(username);
		System.out.println(Password);
	}
	
	@Then("user will be logged in successfully")
	public void user_will_be_logged_in_successfully() {
		System.out.println("successs login");
	}
	
	
	

	@Then("user will be NOT logged in successfully")
	public void user_will_be_not_logged_in_successfully() {
		System.out.println("NOT login");
	}
	
	

	
}