package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.BasePage;
import ui.util.ConfigProvider;


public class HomePage extends BasePage {

    @Getter
    @FindBy(xpath = "//div/a/span[contains(text(),'My Account')]")
    private WebElement myAccount;

    @Getter
    @FindBy(xpath = "//ul/li/a[contains(text(),'Register')]")
    private WebElement registerButton;

    @Getter
    @FindBy(xpath = "//ul/li/a[contains(text(),'Login')]")
    private WebElement loginButton;


    public HomePage() {
        BasePage.driver.get(ConfigProvider.URL);
        PageFactory.initElements(BasePage.driver, this);
    }

    public HomePage openRegisterPage() {
        myAccount.click();
        registerButton.click();
        return this;
    }

    public HomePage openLoginPage() {
        myAccount.click();
        loginButton.click();
        return this;
    }


}
