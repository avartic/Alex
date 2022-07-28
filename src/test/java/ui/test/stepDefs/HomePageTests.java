package ui.test.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
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
                scenarioContext.addToStorage(StorageKey.WEB_PAGE, homePage);
                Assert.assertTrue(homePage.getLogoImage().isDisplayed(), pageName + " is displayed");
                ScreenShotUtils.takePageScreenshot(pageName);
                break;
            case "Login Page":
                LoginPage loginPage = new LoginPage();
                scenarioContext.addToStorage(StorageKey.WEB_PAGE, loginPage);
                homePage.openLoginPage();
                Assert.assertTrue(loginPage.getEmailInputLabel().isDisplayed(), pageName + " is displayed");
                ScreenShotUtils.takePageScreenshot(pageName);
                break;
            case "Register Page":
                RegisterPage registerPage = new RegisterPage();
                scenarioContext.addToStorage(StorageKey.WEB_PAGE, registerPage);
                homePage.openRegisterPage();
                Assert.assertTrue(registerPage.getEmailInputLabel().isDisplayed(), pageName + " is displayed");
                ScreenShotUtils.takePageScreenshot(pageName);
            default:
                System.out.println("Page " + pageName + " don't exist");
        }
    }

    @When("user click on {string}")
    public void userClickOnMyAccount(String elementName) throws IOException {
        HomePage page = (HomePage) scenarioContext.getFromStorage(StorageKey.WEB_PAGE);
        switch (elementName) {
            case "My Account" -> {
                page.getMyAccount().click();
                ScreenShotUtils.highlightAndTakeScreenshot(page.getMyAccount());
            }
            case "Login" -> {
                page.getLoginButton().click();
                ScreenShotUtils.takePageScreenshot(String.valueOf(page));
            }
            case "Register" -> {
                page.getRegisterButton().click();
                ScreenShotUtils.takePageScreenshot(String.valueOf(page));
            }
            default -> System.out.println("Element " + elementName + " don't exist");
        }
    }


    @Then("{string} button is displayed")
    public void loginButtonIsDisplayed(String elementName) throws IOException {
        HomePage page = (HomePage) scenarioContext.getFromStorage(StorageKey.WEB_PAGE);
        switch (elementName) {
            case "Login" -> {
                Assert.assertTrue(page.getLoginButton().isDisplayed(), page.getLoginButton().getText() + " is displayed");
                ScreenShotUtils.highlightAndTakeScreenshot(page.getLoginButton());
            }
            case "Register" -> {
                Assert.assertTrue(page.getLoginButton().isDisplayed(), page.getRegisterButton().getText() + " is displayed");
                ScreenShotUtils.highlightAndTakeScreenshot(page.getRegisterButton());
            }
            default -> System.out.println("Element " + elementName + " don't exist");
        }
    }

    @Then("user is redirected to {string}")
    public void userIsRedirectedToLoginPage(String pageName) throws IOException {
        switch (pageName) {
            case "Home Page" -> {
                HomePage homePage = new HomePage();
                Assert.assertTrue(homePage.getLogoImage().isDisplayed(), pageName + " is displayed");
                ScreenShotUtils.takePageScreenshot(pageName);
            }
            case "Login Page" -> {
                LoginPage loginPage = new LoginPage();
                Assert.assertTrue(loginPage.getEmailInputLabel().isDisplayed(), pageName + " is displayed");
                ScreenShotUtils.takePageScreenshot(pageName);
            }
            case "Register Page" -> {
                RegisterPage registerPage = new RegisterPage();
                Assert.assertTrue(registerPage.getEmailInputLabel().isDisplayed(), pageName + " is displayed");
                ScreenShotUtils.takePageScreenshot(pageName);
            }
            default -> System.out.println("Page " + pageName + " don't exist");
        }
    }
}
