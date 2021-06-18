package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientLoginPage extends BasePage {
    @FindBy(name = "email") public WebElement email;
    @FindBy(name = "password2") public WebElement password;
    @FindBy (id = "inputbtn") public WebElement loginButton;

    public PatientLoginPage(WebDriver driver) {
        super(driver);
    }
}
