package ui.util;

import io.cucumber.datatable.DataTable;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;


@Slf4j
public class CustomTestListener implements ConcurrentEventListener {

    public CustomTestListener() {
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::handleStepStarted);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::handleStepFinished);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::handleCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::handleCaseFinished);
    }

    private void handleCaseFinished(TestCaseFinished t) {
        log.info("[TEST FINISHED] " + t.getTestCase().getName());
    }

    private void handleCaseStarted(TestCaseStarted t) {
        log.info("[TEST STARTED]  " + t.getTestCase().getName());
    }

    private void handleStepFinished(TestStepFinished t) {
        if (t.getTestStep() instanceof PickleStepTestStep) {
            log.info("[STEP {}]   {}", t.getResult().getStatus(), ((PickleStepTestStep) t.getTestStep()).getStep().getText());
        }
        if (t.getResult().getStatus().equals(Status.FAILED)) {
            log.info("[ERROR]       ", t.getResult().getError());
        }
    }

    private void handleStepStarted(TestStepStarted t) {
        if (t.getTestStep() instanceof PickleStepTestStep) {
            var testStep = (PickleStepTestStep) t.getTestStep();
            var msg = "[STEP STARTED]  " + testStep.getStep().getText();
            if (Objects.nonNull(testStep.getStep().getArgument())) {
                var arg = testStep.getStep().getArgument();
                msg += System.lineSeparator();
                if (DataTableArgument.class.isAssignableFrom(arg.getClass())) {
                    msg += DataTable.create(((DataTableArgument) arg).cells()).toString();
                } else if (DocStringArgument.class.isAssignableFrom(arg.getClass())) {
                    msg += ((DocStringArgument) arg).getContent();
                }
            }
            log.info(msg);
        }
    }
}