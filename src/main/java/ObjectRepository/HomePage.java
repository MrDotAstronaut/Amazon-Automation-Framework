package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;
    @FindBy(id = "nav-link-accountList")
    private WebElement accountButton;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement accountInfo;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchField() {
        return searchField;
    }
    public WebElement getSearchButton(){
        return searchButton;
    }
    public WebElement getAccountButton(){
        return accountButton;
    }
    public WebElement getAccountInfo() {
        return accountInfo;
    }

}
