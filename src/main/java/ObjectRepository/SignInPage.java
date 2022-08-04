package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;

    @FindBy(id = "ap_email")
    private WebElement emailField;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "ap_password")
    private WebElement passwordField;
    @FindBy(id = "signInSubmit")
    private WebElement signinButton;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getEmailField(String s) {
        emailField.sendKeys(s);
    }
    public void getContinueButton() {
        continueButton.click();
    }
    public void getPasswordField(String s) {
        passwordField.sendKeys(s);
    }
    public void getSigninButton() {
        signinButton.click();
    }

}
