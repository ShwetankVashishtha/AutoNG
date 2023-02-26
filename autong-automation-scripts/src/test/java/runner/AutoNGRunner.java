package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = { "src/test/java/features/webApp/Login.feature" },
        glue = { "steps" },
        plugin = { "pretty" },
        tags = "@login")
@RunWith(Cucumber.class)
public class AutoNGRunner {}