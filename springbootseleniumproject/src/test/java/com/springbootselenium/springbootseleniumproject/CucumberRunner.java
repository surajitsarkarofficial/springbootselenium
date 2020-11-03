package com.springbootselenium.springbootseleniumproject;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "classpath:features",
        glue ="com.springbootselenium.springbootseleniumproject.bdd",
        tags={"@visa"},
        plugin = {
                "pretty",
                "html:reports"
        }

        )
public class CucumberRunner extends AbstractTestNGCucumberTests {
        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
