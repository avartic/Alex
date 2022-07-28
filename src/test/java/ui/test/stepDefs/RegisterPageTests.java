package ui.test.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RegisterPage;
import ui.test.util.BaseTest;

import java.util.Map;

public class RegisterPageTests extends BaseTest {

    @Then("all required elements are present on Register page")
    public void followingElementsArePresent() {
        RegisterPage registerPage = new RegisterPage();
        Assert.assertTrue( registerPage.getFirstNameInputLabel().isDisplayed(), "First Name Input field is displayed");
        Assert.assertTrue( registerPage.getLastNameInputLabe().isDisplayed(), "Last Name Input field is displayed");
        Assert.assertTrue( registerPage.getEmailInputLabel().isDisplayed(), "Email Input field is displayed");
        Assert.assertTrue( registerPage.getPasswordInputLabel().isDisplayed(), "Password Input field is displayed");
        Assert.assertTrue( registerPage.getSubmitButton().isDisplayed(), "Submit button is displayed");
        Assert.assertTrue( registerPage.getAcceptPrivacyPolicyCheckBox().isDisplayed(), "Accept Privacy Policy checkbox is displayed");
        Assert.assertTrue( registerPage.getSubscribeRadioButtonFalse().isDisplayed(), "Subscribe False Radio Button is displayed");
        Assert.assertTrue( registerPage.getSubscribeRadioButtonTrue().isDisplayed(), "Subscribe True Radio Button is displayed");
    }

    @When("user populates fields with following data on Register page")
    public void userPopulatesFieldsWithFollowingDataOnRegisterPage(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        RegisterPage registerPage = new RegisterPage();
        registerPage.getFirstNameInputLabel().sendKeys(data.get("First Name Input"));
        registerPage.getLastNameInputLabe().sendKeys(data.get("Last Name Input"));
        registerPage.getEmailInputLabel().sendKeys(data.get("Email Input"));
        registerPage.getPasswordInputLabel().sendKeys(data.get("Password Input"));
        registerPage.getAcceptPrivacyPolicyCheckBox().click();
    }

    @When("user click on Submit button from Register page")
    public void userClickOnSubmitButtonFromRegisterPage() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.getSubmitButton().click();
    }
}
