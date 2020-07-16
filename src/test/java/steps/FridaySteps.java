package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.enums.WeekDay;

import static org.junit.Assert.assertEquals;

public class FridaySteps {
    private String today;
    private String actualAnswer;

    @Given("today is {weekDay}")
    public void today_is_Sunday(WeekDay weekDay) {
        today = weekDay.toString();
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = new IsItFriday().isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    class IsItFriday {
        String isItFriday(String today) {
            return today.toLowerCase().equals("friday") ? "Yes" : "No";
        }
    }
}
