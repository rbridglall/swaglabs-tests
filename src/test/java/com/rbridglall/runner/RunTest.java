package com.rbridglall.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target"},
        features = "src/test/resources/features",
        glue = {"com.rbridglall"}
)
public class RunTest {
}
