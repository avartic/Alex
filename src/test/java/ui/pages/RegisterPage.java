package ui.pages;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.util.BasePage;


public class RegisterPage extends BasePage {

    @Getter
    @Setter
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInputLabel;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInputLabe;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputLabel;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputLabel;


    @Getter
    @FindBy(xpath = "//input[@type='radio' and @value='1']")
    private WebElement subscribeRadioButtonTrue;

    @Getter
    @FindBy(xpath = "//input[@type='radio' and @value='0']")
    private WebElement subscribeRadioButtonFalse;


    @Getter
    @FindBy(xpath = "//input[@type='checkbox' and @value='1']")
    private WebElement acceptPrivacyPolicyCheckBox;


    @Getter
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;


    public RegisterPage() {
        PageFactory.initElements(BasePage.driver, this);
    }


}
