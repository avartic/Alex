package ui.test.util;


import lombok.Getter;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {

    @Autowired
    @Getter
    protected ScenarioContext scenarioContext;

    protected SoftAssertions softAssert() {
        return scenarioContext.getSoftAssertions();
    }

}