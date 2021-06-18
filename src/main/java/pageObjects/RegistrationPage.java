package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    @FindBy(name = "fname") public WebElement firstName;
    @FindBy (name = "lname") public WebElement lastName;
    @FindBy (name = "email") public WebElement email;
    @FindBy (xpath = "//*[@id=\"home\"]/form/div/div[2]/div[2]/input")public WebElement phone;
    @FindBy (id = "password") public WebElement password;
    @FindBy (name = "cpassword") public WebElement confirmPassword;
    @FindBy (name = "patsub1") public WebElement registerButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


}
