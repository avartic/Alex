package ui.test.stepDefs;

import api.dto.UserData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import ui.test.util.BaseTest;
import ui.test.util.ScreenShotUtils;

import java.io.IOException;

public class LoginPageTests extends BaseTest {

    @Then("all required elements are present on Login page")
    public void followingElementsArePresent() throws IOException {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.getEmailInputLabel().isDisplayed(), "Email Input field is displayed");
        Assert.assertTrue(loginPage.getPasswordInputLabel().isDisplayed(), "Password Input field is displayed");
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed(), "Submit button is displayed");
        ScreenShotUtils.takePageScreenshot(loginPage.toString());
    }

    @When("user populates fields with following data on Login page")
    public void userPopulatesFieldsWithFollowingDataOnRegisterPage(UserData userData) throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.getEmailInputLabel().sendKeys(userData.getEmail());
        loginPage.getPasswordInputLabel().sendKeys(userData.getPassword());
        ScreenShotUtils.takePageScreenshot(loginPage.toString());
    }


    @When("user click on Submit button from Login page")
    public void userClickOnSubmitButtonFromLoginPage() throws IOException {
        LoginPage loginPage = new LoginPage();
        ScreenShotUtils.highlightAndTakeScreenshot(loginPage.getSubmitButton());
        loginPage.getSubmitButton().click();
    }
}
