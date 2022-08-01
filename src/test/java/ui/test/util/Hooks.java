package ui.test.util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;

import java.io.File;
import java.time.Duration;

import static ui.test.util.StorageKey.DRIVER;

public class Hooks extends BaseTest {


    protected WebDriver driver;
    public static String scenarioName = "";
    public static String featureFileName = "";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
        scenarioContext.addToStorage(DRIVER, driver);
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Before(order = 100)
    public void getScenarioNameAndFeatureName(Scenario scenario) {
        scenarioName = scenario.getName();
        featureFileName = new File(scenario.getUri()).getName().replace(".feature", "");
    }
}
