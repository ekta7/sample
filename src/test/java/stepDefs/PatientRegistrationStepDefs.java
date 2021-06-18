package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class PatientRegistrationStepDefs {

    RegistrationPage registrationPage;
    public static WebDriver driver;

    @BeforeEach
    public static WebDriver startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
            startBrowser();
            driver.manage().window().maximize();
            driver.get(url);
            registrationPage = new RegistrationPage(driver);
        }


   @When("user enters First Name as {string}")
    public void user_enters_first_name_as(String firstname) {

        registrationPage.firstName.sendKeys(firstname);
    }
   @When("user enters Last name as {string}")
    public void user_enters_last_name_as(String lastname) {
        registrationPage.lastName.sendKeys(lastname);

    }
    @When("user enters Email as {string}")
    public void user_enters_email_as(String email) {
        registrationPage.email.sendKeys(email);

    }
    @When("user enters Phone as {string}")
    public void user_enters_phone_as(String phone) {
        registrationPage.phone.sendKeys(phone);
        // driver.findElement(By.xpath("//*[@id=\"home\"]/form/div/div[2]/div[2]/input")).sendKeys(phone);
    }
    @When("User enters Password as {string}")
    public void user_enters_password_as(String password) {
        registrationPage.password.sendKeys(password);

    }
    @When("User Confirms Password as  {string}")
    public void user_confirms_password_as(String confirmpwd) {
        registrationPage.confirmPassword.sendKeys(confirmpwd);

    }
    @When("User clicks Register button")
    public void user_clicks_register_button() {
        registrationPage.registerButton.click();

    }
    @Then("user is directed to his\\/her dashboard")
    public void user_is_directed_to_his_her_dashboard() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Welcome"));
        //Assert.assertEquals("Welcome",driver.findElement(By.tagName("h3")).getText());
        System.out.println("success");
    }

    @Then("user should see error message as {string}")
    public void user_should_see_error_message_as(String string) {

    }
    @AfterEach
    public static void stopDriver(){
        driver.quit();
        driver = null;
    }

}
