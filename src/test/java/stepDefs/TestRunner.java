package stepDefs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions
        (
                features = {"src/test/resources/featureFiles/BookAppointment.feature"},
                glue = {"stepDefs"},
                tags = "@bookAppointment",
//                dryRun = true,
                plugin = {"pretty","html:target/report.html"}

        )

@RunWith(Cucumber.class)
public class TestRunner
{

}


