package BlankFactor.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features.blankfactor/check_industries_information.feature",
        glue = "BlankFactor.stepdefinitions",
        plugin = {"pretty"},
        tags = "@DesktopTest"
)
public class CheckIndustriesIT {
}