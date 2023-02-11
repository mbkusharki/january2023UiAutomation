package StepDef;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NextStepDef extends BaseUtil
{
    private BaseUtil base;

    public NextStepDef(BaseUtil base){this.base=base;};

    @Given("I am on the next Landing  page")
    public void i_am_on_the_next_landing_page()
    {
        base.driver.manage().window().maximize();
        base.driver.get("https://www.next.co.uk/");
        base.driver.findElement(By.xpath("//button[@class = 'onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();
        base.driver.findElement(By.xpath("//span[@class = 'header-s2mb6j']")).click();

    }
    @When("I navigate to the Home Furnishing Link")
    public void i_navigate_to_the_home_furnishing_link()
    {
        base.driver.findElement(By.xpath("//a[@href = 'https://www.next.co.uk/furniture']")).click();

    }
    @Then("the Home Furnishing page should be displayed")
    public void the_home_furnishing_page_should_be_displayed()
    {
        assertThat(base.driver.findElement(By.xpath("//div[contains(text( ), 'furniture')]")).isDisplayed(), is(true));
    }
}
