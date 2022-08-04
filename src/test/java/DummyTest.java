import Base.Base;
import ObjectRepository.HomePage;
import ObjectRepository.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class DummyTest extends Base {

    private WebDriver driver;
    private Properties props;

    @BeforeTest
    public void TC001_PRE() throws IOException {
        props = initProps();
        driver = initDriver();
        preCondition();
    }

    @Test
    public void TC001(){
        HomePage hp = new HomePage(driver);
        hp.getAccountButton().click();
        SignInPage sp = new SignInPage(driver);
        sp.getEmailField(props.getProperty("email"));
        sp.getContinueButton();
        sp.getPasswordField(props.getProperty("password"));
        sp.getSigninButton();
        Assert.assertEquals(hp.getAccountInfo().getText(), "Hello, John");
    }

    @AfterTest
    public void TC001_POST(){
        postCondition();
    }

}
