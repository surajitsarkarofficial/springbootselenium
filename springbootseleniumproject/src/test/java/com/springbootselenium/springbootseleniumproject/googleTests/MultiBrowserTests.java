package com.springbootselenium.springbootseleniumproject.googleTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTests extends SpringBaseTestNGTests {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void runMultiBrowser()
    {
        this.ctx.getBean("chromeDriver", WebDriver.class).get("http://www.google.com");
        this.ctx.getBean("firefoxDriver", WebDriver.class).get("http://www.yahoo.com");
    }
}
