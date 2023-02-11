package StepDef;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UKBATestStepDef extends BaseUtil
{
    private BaseUtil base;

    public UKBATestStepDef(BaseUtil base){this.base=base;}
    @Given("I am on {string}")
    public void i_am_on(String url_UKBA) {
        // Write code here that turns the phrase above into concrete actions
        base.driver.manage().window().maximize();
        base.driver.get(url_UKBA);
    }

    @When("I provide nationality of {string}")
    public void i_provide_nationality_of(String countryName) {
        // Write code here that turns the phrase above into concrete actions
        Select select = new Select(base.driver.findElement(By.id("response")));
        select.selectByVisibleText(countryName);
    }

    @When("I click on Continue button")
    public void i_click_on_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        base.driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
    }

    @When("I select reason as {string}")
    public void i_select_reason_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        base.driver.findElement(By.xpath("//input[@value='study']")).click();
    }

    @When("I state that I intend to stay for more than {int} months")
    public void i_state_that_i_intend_to_stay_for_more_than_months(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        base.driver.findElement(By.xpath("//label[contains(text(),'longer than 6 months')]")).click();
    }

    @Then("I should be informed that {string}")
    public void i_should_be_informed_that(String msg) {
        // Write code here that turns the phrase above into concrete actions
//        assertThat(base.driver.findElement(By.xpath("//h2[contains(text(),'You’ll need a visa to study in the UK')]")).isDisplayed(), is(true));

        assertThat(base.driver.findElement(By.xpath("//h2[contains(text(),'" + msg    +     "')]")).isDisplayed(), is(true));
    }
    @When("I select reason for travel as {string}")
    public void i_select_reason_for_travel_as(String string)
    {
        base.driver.findElement(By.xpath("//input[@value = 'tourism']")).click();
    }
    @Then("I should get the message as that {string}")
    public void i_should_get_the_message_as_that(String msg)
    {
        assertThat(base.driver.findElement(By.xpath("//h2[contains(text(),'" + msg    +     "')]")).isDisplayed(), is(true));
    }
    @When("I state I am not travelling or visiting a partner or family")
    public void i_state_i_am_not_travelling_or_visiting_a_partner_or_family()
    {
        base.driver.findElement(By.xpath("//input[@value = 'no']")).click();
    }
    @Then("I should get informed that {string}")
    public void i_should_get_informed_that(String msg)
    {
        assertThat(base.driver.findElement(By.xpath("//h2[contains(text ( ),'" + msg    +     "')]")).isDisplayed(), is(true));
    }
}
