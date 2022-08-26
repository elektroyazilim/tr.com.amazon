package amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-tr.com.amazon_reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue = "amazon.stepdefinitions", // the path is taken from "copy reference"
        tags = "@hata",
        dryRun = false  // defaultta false olacak.
)

// if you want to use cukesrunner, you should put code(step definitions file) contains selenium code,
// dont try sysout, if you try you take undefined step definitions error, mvn commands not works
// mvn clean install

public class CukesRunner {
}
