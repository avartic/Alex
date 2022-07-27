import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "ui.test.util.CustomTestListener"},
        glue = {"ui.test"},
        features = "src/test/resources/features",
        tags = "@Run")
public class CucumberRunner {
}
