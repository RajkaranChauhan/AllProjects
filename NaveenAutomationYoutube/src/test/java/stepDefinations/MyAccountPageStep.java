package stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.MyAccountPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountPageStep {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private MyAccountPage myAccountPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialTable)
//	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) 
	{
	  List< Map<String, String>> credList = credentialTable.asMaps();
	  String userName=credList.get(0).get("username");
	  String password =  credList.get(0).get("password");
	  
	  DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
	  myAccountPage= loginPage.doLogin(userName, password);
	}

	@Given("user is on My Accounts page")
	public void user_is_on_my_accounts_page() {
		String title = myAccountPage.getMyAccountPageTitle();
	  System.out.println("user is on My Accounts page having page title as "+ title);
	}

	@When("user gets the title of the My Accounts page")
	public void user_gets_the_title_of_the_My_Accounts_page() {
		String title = myAccountPage.getMyAccountPageTitle();
		  System.out.println("user gets the title of My Accounts page  as "+ title);
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String myAccountPageTitle) {
	   
	    Assert.assertTrue(myAccountPage.getMyAccountPageTitle().contains(myAccountPageTitle));
	}

	@Then("user gets accounts section")
//	public void user_gets_accounts_section(io.cucumber.datatable.DataTable dataTable)
	public void user_gets_accounts_section(DataTable sectiontable)
	{
		List<String> expAccountsectionList=sectiontable.asList();
		System.out.println("Expected account seciton list"+expAccountsectionList);
		
		
		List<String> actulAccountsectionList=myAccountPage.getAccountSectionsList();
		System.out.println("Actual account seciton list"+actulAccountsectionList);
		
		Assert.assertTrue(expAccountsectionList.containsAll(actulAccountsectionList));
	   
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	 
		Assert.assertTrue(myAccountPage.getMyAccounrSectionCount()== expectedSectionCount );
	}


}
