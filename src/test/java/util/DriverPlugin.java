package util;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DriverPlugin implements EventListener {

    private final String driverName;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, e -> DriverStore.init(driverName));

        publisher.registerHandlerFor(TestRunFinished.class, e -> DriverStore.closeDriver());
    }
}