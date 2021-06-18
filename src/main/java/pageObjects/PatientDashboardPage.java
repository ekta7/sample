package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDashboardPage extends BasePage
{

    //@FindBy(xpath = "//a[@href= '#list-home']") public WebElement bookAppointmentLink;
    //@FindBy(xpath = "//*[@id="list-dash"]/div/div[1]/div[1]/div/div/p/a")
    @FindBy(id = "list-home-list") public WebElement bookAppointmentLink;
    public PatientDashboardPage(WebDriver driver) {
        super(driver);
    }
}
