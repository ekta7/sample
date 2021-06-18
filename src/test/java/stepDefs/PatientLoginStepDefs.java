package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PatientDashboardPage;
import pageObjects.PatientLoginPage;

public class PatientLoginStepDefs {

    public static WebDriver driver;
    PatientLoginPage patientloginpage;
    PatientDashboardPage patientdashboardpage;

    public static WebDriver startBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


    @Given("User is logged in")
    public void user_is_on_his_dashboard() {
        startBrowser();
        driver.manage().window().maximize();
        driver.get("https://gentle-mountain-53237.herokuapp.com/");
        driver.findElement(By.linkText("Already have an account?")).click();
        Assert.assertEquals("Patient Login", driver.findElement(By.tagName("h3")).getText());

        patientloginpage = new PatientLoginPage(driver);
        patientloginpage.email.sendKeys("test@yahoo.com");
        patientloginpage.password.sendKeys("TEST123");
        patientloginpage.loginButton.click();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Welcome"));

        driver.findElement(By.linkText("Book Appointment")).click();

        }

   /* @After
    public static void stopDriver(){
        driver.quit();
        driver = null;
    }*/


}
