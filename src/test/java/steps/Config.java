package steps;

import io.cucumber.java.ParameterType;
import steps.enums.WeekDay;

public class Config {

    @ParameterType("'(.*)'")
    public WeekDay weekDay(String input) {
        return WeekDay.valueOf(input.toUpperCase());
    }
}
