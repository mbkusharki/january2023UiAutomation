package StepDef;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class NopCommerceStepDef extends BaseUtil
{
    private BaseUtil base;
    public NopCommerceStepDef (BaseUtil base)
    {
        this.base = base;
    }
    @Given("I am on NopCommerce home page")
    public void i_am_on_nop_commerce_home_page()
    {
        // Write code here that turns the phrase above into concrete actions
        base.driver.manage().window().maximize();
        base.driver.get("https://demo.nopcommerce.com/");
//        base.driver.navigate().to("https://www.demo.nopcommerce.com");
    }
    @When("I click on Register link")
    public void i_click_on_register_link()
    {
        // Write code here that turns the phrase above into concrete actions
        WebElement registerButton;
        registerButton = base.driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerButton.click();
    }
    @When("I populate only the mandatory fields firstname as {string}, lastname as {string}, and email as {string}, password and ConfirmPassword as {string}")
    public void i_populate_only_the_mandatory_fields_firstname_as_lastname_as_and_email_as_password_and_confirm_password_as(String fName, String lName, String eMail, String passWord) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement firstName = base.driver.findElement(By.id("FirstName"));
        firstName.sendKeys(fName);
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

    @When("I click on register button")
    public void i_click_on_register_button()
    {
        // Write code here that turns the phrase above into concrete actions
        base.driver.findElement(By.id("register-button")).click();

    }
    @Then("registration is successful")
    public void registration_is_successful()
    {
        // Write code here that turns the phrase above into concrete actions
        assertThat(base.driver.findElement(By.xpath("//div[contains(text(), 'Your registration completed')]")).isDisplayed(), is(true));
    }

    @And("I populate day as {string}, month as {string}, year as {string}, and company as {string}")
    public void iPopulateDayAsMonthAsYearAsAndCompanyAs(String day, String month, String year, String company)
    {
        Select sDay = new Select(base.driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        sDay.selectByVisibleText(day);
        Select sMonth = new Select(base.driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        sMonth.selectByVisibleText(month);
        Select sYear = new Select(base.driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
        sYear.selectByVisibleText(year);
        base.driver.findElement(By.id("Company")).sendKeys(company);
    }
}
