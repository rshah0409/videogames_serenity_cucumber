package com.videogames.cucumber;

import com.videogames.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/featurefile/videogames.feature")

public class CucumberRunner extends TestBase {


}
