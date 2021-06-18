package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.PatientDashboardPage;
import pageObjects.PatientLoginPage;

import java.util.concurrent.TimeUnit;

public class BookAppointmentStepDefs {
    public static WebDriver driver;
    PatientLoginPage patientloginpage;
    PatientDashboardPage patientDashboardPage;

    @Before
    public static WebDriver startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
    @Given("User is on his dashboard")
    public void user_is_on_his_dashboard() {
        startBrowser();
        driver.manage().window().maximize();
        driver.get("https://gentle-mountain-53237.herokuapp.com/");
        driver.findElement(By.linkText("Already have an account?")).click();
        Assert.assertEquals("Patient Login",driver.findElement(By.tagName("h3")).getText());
        String test1 = driver.findElement(By.tagName("h3")).getText();
        System.out.println(test1);



        patientloginpage = new PatientLoginPage(driver);
        patientloginpage.email.sendKeys("test@yahoo.com");
        patientloginpage.password.sendKeys("TEST123");
        patientloginpage.loginButton.click();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Welcome"));

    }
    @When("user clicks Book appointment link or Book appointment tab")
    public void user_clicks_book_appointment_link_or_book_appointment_tab() {
        driver.findElement(By.linkText("Book Appointment")).click();
        //Thread.sleep(2000);
        String test = driver.findElement(By.tagName("h4")).getText();
        System.out.println(test);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Then("user is directed to create appointment page")
    public void user_is_directed_to_create_appointment_page() throws InterruptedException {
    Thread.sleep(2000);
    String title = driver.findElement(By.xpath("//div[@class ='card-body']//center//h4")).getText();
        System.out.println(title);
      Assertions.assertEquals("Create an appointment",title);

    }
    @When("user selects Specialization from the dropdown")
    public void user_selects_specialization_from_the_dropdown() {
        Select s = new Select(driver.findElement(By.className("form-control")));
        s.selectByIndex(3);
        //s.selectByVisibleText("Neurologist");

    }
    @When("user selects Doctor name from the dropdown")
    public void user_selects_doctor_name_from_the_dropdown() {
        Select s =new Select(driver.findElement(By.name("doctor")));
        s.selectByIndex(2);
    }
    @When("user selects future date from the calendar")
    public void user_selects_future_date_from_the_calendar() {
        driver.findElement(By.name("appdate")).sendKeys("21/07/2021");
    }
    @When("user selects appointment time from dropdown")
    public void user_selects_appointment_time_from_dropdown() throws InterruptedException {
        Select s = new Select(driver.findElement(By.id("apptime")));
        s.selectByIndex(2);
        Thread.sleep(2000);
    }
    @When("user clicks Create new entry")
    public void user_clicks_create_new_entry() throws InterruptedException {
    driver.findElement(By.name("app-submit")).click();
    Thread.sleep(2000);
    }
    @Then("user receives an alert as {string}")
    public void user_receives_an_alert_as(String string) {
        System.out.println("Appointment booked");
    }

    @After
    public static void stopDriver(){
        driver.quit();
        driver = null;
    }

}
