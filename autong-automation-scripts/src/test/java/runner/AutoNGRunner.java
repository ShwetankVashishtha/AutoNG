package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = {"src/test/java/features/webApp"},
        glue = {"steps"},
        plugin = {"pretty"},
        monochrome = false)
@RunWith(Cucumber.class)
public class AutoNGRunner {
}