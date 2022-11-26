package runner;

import Utils.Driver;
import Utils.GlobalParameters;
import Utils.ServerManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"}
        ,features = {"src/test/java/features"}
        ,glue = {"steps"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,tags = "@test"

)

public class Testrunner {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParameters params = new GlobalParameters();
        params.initializeGlobalParams();
        new ServerManager().startServer();
        new Driver().startDriver();
    }

    @AfterClass
    public static void quit() {

        new Driver().getDriver().quit();
        new ServerManager().getServer().stop();


    }
}

