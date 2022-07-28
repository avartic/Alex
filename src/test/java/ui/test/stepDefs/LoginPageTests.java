package ui.test.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import ui.test.util.BaseTest;

import java.util.Map;

public class LoginPageTests extends BaseTest {

    @Then("all required elements are present on Login page")
    public void followingElementsArePresent() {
        LoginPage registerPage = new LoginPage();
        Assert.assertTrue(registerPage.getEmailInputLabel().isDisplayed(), "Email Input field is displayed");
        Assert.assertTrue(registerPage.getPasswordInputLabel().isDisplayed(), "Password Input field is displayed");
        Assert.assertTrue(registerPage.getSubmitButton().isDisplayed(), "Submit button is displayed");
    }

    @When("user populates fields with following data on Login page")
    public void userPopulatesFieldsWithFollowingDataOnRegisterPage(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        LoginPage registerPage = new LoginPage();
        registerPage.getEmailInputLabel().sendKeys(data.get("Email Input"));
        registerPage.getPasswordInputLabel().sendKeys(data.get("Password Input"));
    }


    @When("user click on Submit button from Login page")
    public void userClickOnSubmitButtonFromLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.getSubmitButton().click();
    }
}
