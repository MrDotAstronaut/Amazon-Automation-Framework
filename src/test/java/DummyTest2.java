import Base.Base;
import ObjectRepository.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class DummyTest2 extends Base {

    private WebDriver driver;
    private Properties props;

    @BeforeTest
    public void TC002_PRE() throws IOException {
        props = initProps();
        driver = initDriver();
        preCondition();
    }

    @Test
    public void TC002(){
        HomePage hp = new HomePage(driver);
        Assert.assertEquals(hp.getAccountInfo().getText(), "Hello, John");
    }

    @AfterTest
    public void TC002_POST(){
        postCondition();
    }
}
