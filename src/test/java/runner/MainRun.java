package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/* Ejecutar con Cucumber */
@RunWith(Cucumber.class)

/* Cucumber Options */
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdefinitions",
        tags = "@Test1"
)

public class MainRun {

}
