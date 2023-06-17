package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.ExcelFileReader;
public class LoginSteps {
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws IOException {
		ExcelFileReader efr = new ExcelFileReader();
		efr.ReadExcelData();
		System.out.println("In user_is_on_login_page");
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password() {
		System.out.println("In entered username and password");
	}

	@And("^Clicks on login button$")
	public void clicks_on_login_button() {
		System.out.println("In clicks_on_login_button");
	}

	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("In user_is_navigated_to_the_home_page");
	}

}
