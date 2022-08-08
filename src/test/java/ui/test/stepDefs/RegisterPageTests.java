package ui.test.stepDefs;

import api.dto.UserData;
import api.service.UserRestClientService;
import config.ConfigProvider;
import db.repository.UserRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.testng.Assert;
import pages.RegisterPage;
import ui.test.util.BaseTest;

import java.util.Map;

import static ui.test.util.StorageKey.USER;

public class RegisterPageTests extends BaseTest {

    private WebClient webClient = WebClient.create(ConfigProvider.REST_URL);

    UserRestClientService userRestClient = new UserRestClientService(webClient);

    @Autowired
    UserRepository userRepository;

    @Then("all required elements are present on Register page")
    public void followingElementsArePresent() {
        RegisterPage registerPage = new RegisterPage();
        Assert.assertTrue(registerPage.getFirstNameInputLabel().isDisplayed(), "First Name Input field is displayed");
        Assert.assertTrue(registerPage.getLastNameInputLabe().isDisplayed(), "Last Name Input field is displayed");
        Assert.assertTrue(registerPage.getEmailInputLabel().isDisplayed(), "Email Input field is displayed");
        Assert.assertTrue(registerPage.getPasswordInputLabel().isDisplayed(), "Password Input field is displayed");
        Assert.assertTrue(registerPage.getSubmitButton().isDisplayed(), "Submit button is displayed");
        Assert.assertTrue(registerPage.getAcceptPrivacyPolicyCheckBox().isDisplayed(), "Accept Privacy Policy checkbox is displayed");
        Assert.assertTrue(registerPage.getSubscribeRadioButtonFalse().isDisplayed(), "Subscribe False Radio Button is displayed");
        Assert.assertTrue(registerPage.getSubscribeRadioButtonTrue().isDisplayed(), "Subscribe True Radio Button is displayed");
    }

    @When("user populates fields with following data on Register page")
    public void userPopulatesFieldsWithFollowingDataOnRegisterPage(UserData userData) {
        RegisterPage page = new RegisterPage();
        page.getFirstNameInputLabel().sendKeys(userData.getFirstName());
        page.getLastNameInputLabe().sendKeys(userData.getLastName());
        page.getEmailInputLabel().sendKeys(userData.getEmail());
        page.getPasswordInputLabel().sendKeys(userData.getPassword());
        if (userData.getSubscription().equals(false) || userData.getSubscription() == null) {
            page.getSubscribeRadioButtonFalse().sendKeys(userData.getPassword());
        } else {
            page.getSubscribeRadioButtonTrue().sendKeys(userData.getPassword());
        }
        page.getAcceptPrivacyPolicyCheckBox().click();
        UserData user = userRestClient.createUser(userData);
        scenarioContext.addToStorage(USER,user);
    }

    @When("user click on Submit button from Register page")
    public void userClickOnSubmitButtonFromRegisterPage() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.getSubmitButton().click();
    }

    @Then("user is saved in DB")
    public void userIsSavedInDB() {
        UserData user = (UserData) scenarioContext.getFromStorage(USER);
        userRepository.findById(user.getUserID());
    }
}
