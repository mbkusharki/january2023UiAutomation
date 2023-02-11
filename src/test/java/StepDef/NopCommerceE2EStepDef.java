package StepDef;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class NopCommerceE2EStepDef extends BaseUtil
{
    private BaseUtil base;

    public NopCommerceE2EStepDef(BaseUtil base){this.base = base; }

    @Given("I am not logged in")
    public void i_am_not_logged_in()
    {
        assertThat(base.driver.findElement(By.linkText("Log in")).isDisplayed(), (is(equalTo(true))));
    }
    @When("I Click on Computers link")
    public void i_click_on_computers_link()
    {
        base.driver.findElement(By.linkText("Computers")).click();
    }
    @When("I Click on Desktops link")
    public void i_click_on_desktops_link()
    {
        base.driver.findElement(By.linkText("Desktops")).click();
    }
    @When("I Click on {string} link")
    public void i_click_on_link(String bYoC)
    {
        base.driver.findElement(By.linkText(bYoC)).click();
    }
    @When("I select {string} of RAM and {string} of HDD")
    public void i_select_of_ram_and_of_hdd(String cRAM, String cHDD)
    {
        Select sRam = new Select(base.driver.findElement(By.cssSelector("select[name = 'product_attribute_2']")));
        sRam.selectByVisibleText(cRAM);
        WebElement clickHDD =(base.driver.findElement(By.cssSelector("label[for = 'product_attribute_3_6']")));
        Actions actions = new Actions(base.driver);
        actions.moveToElement(clickHDD).click().build().perform();
    }
    @When("I click on {string} button")
    public void i_click_on_button(String AddToCart)
    {
        base.driver.findElement(By.id("add-to-cart-button-1")).click();
    }
    @When("I click {string} link")
    public void i_click_link(String shoppingCart)
    {
        base.driver.findElement(By.cssSelector("a[href='/cart']")).click();
    }
    @When("I click on Agree to terms checkbox")
    public void i_click_on_agree_to_terms_checkbox()
    {
        base.driver.findElement(By.id("termsofservice")).click();
    }
    @When("I click on Checkout button")
    public void i_click_on_checkout_button()
    {
        base.driver.findElement(By.cssSelector("button[id ='checkout']")).click();
    }
    @Then("{string} page is displayed")
    public void page_is_displayed(String welcomePage)
    {
        assertThat(base.driver.findElement(By.xpath("//*['Welcome, Please Sign In!']")).isDisplayed(), is(true));
    }

}
