package ui.pages;


import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.BasePage;


public class LoginPage extends BasePage {

    @Getter
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputLabel;

    @Getter
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputLabel;

    @Getter
    @FindBy(xpath = "//a[contains(text(),'Forgotten Password')]")
    private WebElement forgotPasswordLabel;

    @Getter
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;


    public LoginPage() {
        PageFactory.initElements(BasePage.driver, this);
    }


}
