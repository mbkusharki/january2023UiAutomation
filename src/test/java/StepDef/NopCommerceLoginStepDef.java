package StepDef;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static StepDef.NopCommerceStepDef.rNumber;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NopCommerceLoginStepDef extends BaseUtil
{
    public BaseUtil base;
    public NopCommerceLoginStepDef (BaseUtil base)
    {
        this.base = base;
    }
    @Given("I am on the NopCommerce home page")
    public void i_am_on_the_nop_commerce_home_page()
    {
        base.driver.manage().window().maximize();
        base.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @Given("I have no item in the shopping cart")
    public void i_have_no_item_in_the_shopping_cart()
    {
       assertThat(base.driver.findElement(By.xpath("//span[@class = 'cart-qty']")).getText(), is(equalTo ("(0)")));

    }
    @Given("I click on login link")
    public void i_click_on_login_link()
    {
        WebElement loginButton;
        loginButton = base.driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginButton.click();
    }
    @When("I attempt to login using incorrect credentials with email as {string} and password as {string}")
    public void i_attempt_to_login_using_incorrect_credentials_with_email_as_and_password_as(String eMail, String pWord)
    {
        base.driver.findElement(By.id("Email")).sendKeys( pNumber() +eMail);
        base.driver.findElement(By.id("Password")).sendKeys((pWord));
    }
    static int pNumber()
    {
        Random ran = new Random();
        return ran.nextInt(1000);
    }
    @When("I click login button")
    public void i_click_login_button()
    {
        base.driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
    }
    @Then("I should get the appropriate error message displayed")
    public void i_should_get_the_appropriate_error_message_displayed()
    {
        assertThat(base.driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).isDisplayed(), is(true));
    }
    @When("I enter email in invalid format as {string} and password as {string}")
    public void i_enter_email_in_invalid_format_as_and_password_as(String eMail, String pWord)
    {
        base.driver.findElement(By.id("Email")).sendKeys(eMail);
        base.driver.findElement(By.id("Password")).sendKeys((pWord));
    }
   @Then("I should get error message displayed")
   public void i_should_get_error_message_displayed()
   {
       assertThat(base.driver.findElement(By.xpath("//span[@id='Email-error']")).isDisplayed(), is(true));
   }
    @When("I enter valid password as {string}")
    public void i_enter_valid_password_as(String pWord)
    {
        base.driver.findElement(By.id("Password")).sendKeys((pWord));
    }
    @When("I leave the Email field blank as {string}")
    public void i_leave_the_email_field_blank_as(String eMail)
    {
        base.driver.findElement(By.id("Email")).sendKeys(eMail);
    }
    @Then("I should get the appropriate error message")
    public void i_should_get_the_appropriate_error_message()
    {
        assertThat(base.driver.findElement(By.xpath("//span[@id='Email-error']")).isDisplayed(), is(true));
    }

}
