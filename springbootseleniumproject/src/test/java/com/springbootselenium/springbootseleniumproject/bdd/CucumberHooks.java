package com.springbootselenium.springbootseleniumproject.bdd;

import com.springbootselenium.springbootseleniumproject.core.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class CucumberHooks {

    @Autowired
    ScreenshotService screenshotService;

    @Autowired
    ApplicationContext ctx;

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

        @After
        public void afterScenario()
        {
            this.ctx.getBean(WebDriver.class).quit();
        }
}
