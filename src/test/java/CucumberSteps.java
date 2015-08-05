package test.java;

import main.java.Postfix;
import main.java.PostfixEvaluation;
import junit.framework.TestCase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps extends TestCase{
	
	Postfix postfix = new Postfix();
	String evaluate;
	
	@Given("^the input as \"([^\"]*)\"$")
	public void the_input_as(String arg1) throws Throwable {
		postfix.setPostfixInput(arg1);
	}

	@When("^I select \"([^\"]*)\"$")
	public void I_select(String arg1) throws Throwable {
		evaluate = arg1;
	}

	@Then("^the Result fields should be \"([^\"]*)\"$")
	public void the_Result_fields_should_be(String arg1) throws Throwable {
		PostfixEvaluation pfe = new PostfixEvaluation();
		assertEquals(arg1, pfe.evaluate(postfix.getPostfixInput()));
	}
	
}
