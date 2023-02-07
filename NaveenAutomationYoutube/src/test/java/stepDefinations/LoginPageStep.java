package stepDefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String loginPageTitle;
	private String homePageTitle;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginPageTitle = loginPage.loginPageTitle();
		System.out.println("The title of the login page is :" + loginPageTitle);
	}

	@Then("Loginpage title should be {string}")
	public void loginpage_title_should_be(String expectedLoginPageTitleName) {

		Assert.assertTrue(loginPageTitle.contains(expectedLoginPageTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.lostYourPasswordLinkExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("user gets the title of the Homepage")
	public void user_gets_the_title_of_the_homepage() {
		homePageTitle = loginPage.loginPageTitle();
		System.out.println("The title of the login page is :" + homePageTitle);
	}

	@Then("Home page title should be {string}")
	public void home_page_title_should_be(String expectedHomePageTitleName) {
		Assert.assertTrue(homePageTitle.contains(expectedHomePageTitleName));
	}
}
