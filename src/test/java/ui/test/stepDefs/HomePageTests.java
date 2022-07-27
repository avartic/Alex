package ui.test.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.HomePage;
//import ui.util.ScenarioContext;
import ui.test.util.BaseTest;
import ui.test.util.ScreenShotUtils;
import ui.test.util.StorageKey;

import java.io.IOException;

public class HomePageTests extends BaseTest {


    @Given("user is on {string}")
    public void userIsOnHomePage(String pageName) throws IOException {
        HomePage homePage = new HomePage();
        switch (pageName) {
            case "Home Page":
                getScenarioContext().addToStorage(StorageKey.WEB_PAGE,pageName);
                ScreenShotUtils.highlightAndTakeScreenshot(homePage.getMyAccount());
                homePage.getMyAccount().click();
//                scenarioContext.getFromStorage(StorageKey.WEB_PAGE);
                break;
            case "Login Page":
                homePage.openLoginPage();
                ScreenShotUtils.takePageScreenshot(pageName);
                break;
            case "Register Page":
                homePage.openRegisterPage();
                ScreenShotUtils.takePageScreenshot(pageName);
            default:
                System.out.println("Page " + pageName + "don't exist");
        }


    }

    @Then("{string} button is displayed")
    public void loginButtonIsDisplayed(WebElement element) {

    }
}
