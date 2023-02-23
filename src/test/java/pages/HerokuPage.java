package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuPage {
    public HerokuPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[.='Log In']")
    public WebElement login;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement yazi;

}
