package StepDef;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static StepDef.NopCommerceStepDef.rNumber;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NopCommerceInputFieldValidationStepDef extends BaseUtil
{
    private BaseUtil base;

    public NopCommerceInputFieldValidationStepDef(BaseUtil base){this.base = base; }

    @When("I enter up to maximum of 20xters into the first name input field as {string}")
    public void i_enter_up_to_maximum_of_20xters_into_the_first_name_input_field_as(String fName)
    {
        base.driver.findElement(By.id("FirstName")).sendKeys(fName);
    }
    @When("I enter valid details into lastname as {string}, email as {string}, Password and ConfirmPassword as {string}")
    public void i_enter_valid_details_into_lastname_as_email_as_password_and_confirm_password_as(String lName, String eMail, String passWord) throws InterruptedException {
        base.driver.findElement(By.id("LastName")).sendKeys(lName);
        base.driver.findElement(By.id("Email")).sendKeys(rNumber() +eMail);
        Thread.sleep(4000);
        base.driver.findElement(By.id("Password")).sendKeys(passWord);
        base.driver.findElement(By.id("ConfirmPassword")).sendKeys(passWord);
    }
    static int rNumber()
    {
        Random ran = new Random();
        int rNumber = ran.nextInt(1000);
        return rNumber;
    }

    @When("I enter up to maximum of 20xters into the Last name input field as {string}")
    public void i_enter_up_to_maximum_of_20xters_into_the_last_name_input_field_as(String lName)
    {
        base.driver.findElement(By.id("LastName")).sendKeys(lName);
    }
    @When("I enter valid details into firstname as {string}, email as {string}, Password and ConfirmPassword as {string}")
    public void i_enter_valid_details_into_firstname_as_email_as_password_and_confirm_password_as(String fName, String eMail, String passWord) throws InterruptedException {
        base.driver.findElement(By.id("FirstName")).sendKeys(fName);
        base.driver.findElement(By.id("Email")).sendKeys(rNumber() +eMail);
        Thread.sleep(4000);
        base.driver.findElement(By.id("Password")).sendKeys(passWord);
        base.driver.findElement(By.id("ConfirmPassword")).sendKeys(passWord);
    }

    @When("I enter email address in an incorrect format into the email address input field as {string}")
    public void i_enter_email_address_in_an_incorrect_format_into_the_email_address_input_field_as(String eMail)
    {
        base.driver.findElement(By.id("Email")).sendKeys(eMail);
    }
    @When("I enter valid details into firstname as {string}, lastname as {string}, Password and ConfirmPassword as {string}")
    public void i_enter_valid_details_into_firstname_as_lastname_as_password_and_confirm_password_as(String fName, String lName, String passWord)
    {

        base.driver.findElement(By.id("FirstName")).sendKeys(fName);
        base.driver.findElement(By.id("LastName")).sendKeys(lName);
        base.driver.findElement(By.id("Password")).sendKeys(passWord);
        base.driver.findElement(By.id("ConfirmPassword")).sendKeys(passWord);
    }
    @Then("I should get error message “Wrong email”.")
    public void i_should_get_error_message_wrong_email()
    {
        assertThat(base.driver.findElement(By.xpath("//span[@id='Email-error']")).isDisplayed(), is(true));
    }

    @When("I enter valid password into the Password input field as {string}")
    public void i_enter_valid_password_into_the_password_input_field_as(String passWord)
    {
        base.driver.findElement(By.id("Password")).sendKeys(passWord);
    }
    @When("I enter non matching password into the Confirm password input field as {string}")
    public void i_enter_non_matching_password_into_the_confirm_password_input_field_as(String cpWord)
    {
        base.driver.findElement(By.id("ConfirmPassword")).sendKeys(cpWord);
    }
    @When("I enter valid details into firstname as {string}, lastname as {string}, and email as {string}")
    public void i_enter_valid_details_into_firstname_as_lastname_as_and_email_as(String fName, String lName, String eMail)
    {
        base.driver.findElement(By.id("FirstName")).sendKeys(fName);
        base.driver.findElement(By.id("LastName")).sendKeys(lName);
        base.driver.findElement(By.id("Email")).sendKeys(eMail);
    }
    @Then("I should get error message “The password and confirmation password do not match.” as per design \\(DD05)")
    public void i_should_get_error_message_the_password_and_confirmation_password_do_not_match_as_per_design_dd05()
    {
        assertThat(base.driver.findElement(By.xpath("//span[@id = 'ConfirmPassword-error']")).isDisplayed(), is(true));
    }
    @When("I enter less than six characters in the Password input field as {string}")
    public void i_enter_less_than_six_characters_in_the_password_input_field_as(String passWord)
    {
        base.driver.findElement(By.id("Password")).sendKeys(passWord);
    }
    @Then("I should get a message displayed as per design")
    public void i_should_get_a_message_displayed_as_per_design()
    {
        assertThat(base.driver.findElement(By.xpath("//span[@class = 'field-validation-error']")).isDisplayed(), is(true));
    }

    @When("I leave email as {string}")
    public void i_leave_email_as(String eMail)
    {
        base.driver.findElement(By.id("Email")).sendKeys(eMail);
    }
    @Then("I should get a message “Mandatory field is Required” displayed as per design \\(DD07) for the corresponding Mandatory field")
    public void i_should_get_a_message_mandatory_field_is_required_displayed_as_per_design_dd07_for_the_corresponding_mandatory_field()
    {
        assertThat(base.driver.findElement(By.xpath("//span[@id = 'Email-error']")).isDisplayed(), is(true));
    }
}
