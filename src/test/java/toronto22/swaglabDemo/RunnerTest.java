package toronto22.swaglabDemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
)
public class RunnerTest {
}