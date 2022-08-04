package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    private WebDriver driver;
    private Properties props;

    public Properties initProps() throws IOException {
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
        props = new Properties();
        props.load(fis);
        return props;
    }

    public WebDriver initDriver(){
        switch (props.getProperty("browser")){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
                ChromeOptions opC = new ChromeOptions();
                if(props.getProperty("headless") == "true"){
                    opC.addArguments("headless");
                }
                driver = new ChromeDriver(opC);
                break;

            case "firefox" :
                System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\chromedriver.exe");
                FirefoxOptions opF = new FirefoxOptions();
                if(props.getProperty("headless") == "true"){
                    opF.addArguments("headless");
                }
                driver = new FirefoxDriver(opF);
                break;

            case "edge" :
                System.setProperty("webdriver.msedge.driver", ".\\src\\test\\resources\\msedgedriver.exe");
                EdgeOptions opE = new EdgeOptions();
                if(props.getProperty("headless") == "true"){
                    opE.addArguments("headless");
                }
                driver = new EdgeDriver(opE);
                break;

            case "opera" :
                System.setProperty("webdriver.opera.driver", ".\\src\\test\\resources\\operadriver.exe");
                OperaOptions opO = new OperaOptions();
                if(props.getProperty("headless") == "true"){
                    opO.addArguments("headless");
                }
                driver = new OperaDriver(opO);
                break;
        }
        return driver;
    }

    public void preCondition(){
        driver.get(props.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public void postCondition(){
        driver.quit();
    }
}
