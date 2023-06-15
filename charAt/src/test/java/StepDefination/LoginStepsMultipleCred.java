package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginStepsMultipleCred {
	@Given("^Credentials to login$")
	public void LoginPage() {
		System.out.println("On login page");
	}
	@When("^user enters (.*) and (.*) multiple times$")
	public void EnteringValues(String uname, String pwd) {
		System.out.println("Username " + uname + " and password " + pwd);
	}
	@And("^Login btn Click$")
	public void ClickOnLogin() {
		System.out.println("Click on login");
	}
	
	@Then("^Navigated to the home page$")
	public void NavigatedAtHome() {
		System.out.println("Navigated at home");
	}
}
