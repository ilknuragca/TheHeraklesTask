package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)      //This makes the class runnable
    @CucumberOptions(
            plugin = {
                    "html:target/default-cucumber-reports.html", //html report
                    "json:target/json-reports/cucumber.json",    //json report
                    "junit:target/xml-report/cucumber.xml"      //xml report
            },
            features = "src/test/resources/features",     //path of feature
            glue = {"stepdefinitions","hooks"},          //path of stepdefinitions and hooks
            tags = "@check_of_the_list",
            dryRun = false                       //to check if there is any missing step definition

    )
    public class Runner {
}
