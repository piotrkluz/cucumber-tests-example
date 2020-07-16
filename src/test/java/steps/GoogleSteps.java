package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import util.DriverStore;

public class GoogleSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverStore.getDriver();
    }

    @Given("Google page is open")
    public void google_page_is_open() {
        driver.get("https:\\www.google.com");
    }

    @When("I search for {string}")
    public void i_enter_phrase(String phrase) {
        driver.findElement(By.name("q")).sendKeys(phrase + Keys.RETURN);
    }

    @Then("Search results should appear")
    public void search_results_should_appear() {
        driver.findElement(By.cssSelector("div.g"));
    }
}
