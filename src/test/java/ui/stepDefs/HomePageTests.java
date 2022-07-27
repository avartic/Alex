package ui.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ui.pages.HomePage;
import ui.util.BasePage;
//import ui.util.ScenarioContext;
import ui.util.ScreenShotUtils;
import ui.util.StorageKey;

import java.io.IOException;

public class HomePageTests extends BasePage {


    @Given("user is on {string}")
    public void userIsOnHomePage(String pageName) throws IOException {
        HomePage homePage = new HomePage();
        switch (pageName) {
            case "Home Page":
//                scenarioContext.addToStorage(StorageKey.WEB_PAGE,pageName);
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
