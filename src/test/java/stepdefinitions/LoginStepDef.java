package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;
import weblib.LoginLib;
import webpages.LoginPage;


public class LoginStepDef extends CucumberRunner {

    @Given("^I am on \"([^\"]*)\" page$")
    public void i_am_on_page(String arg1) throws Throwable {

    }

    @When("^I user type \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_user_type_and(String arg1, String arg2) throws Throwable {
        LoginLib.sendKeys(LoginPage.username,arg1);
        LoginLib.sendKeys(LoginPage.password,arg2);
    }

    @Then("^I click submit button$")
    public void i_click_submit_button() throws Throwable {
      LoginLib.click(LoginPage.Login_button);
    }

}
