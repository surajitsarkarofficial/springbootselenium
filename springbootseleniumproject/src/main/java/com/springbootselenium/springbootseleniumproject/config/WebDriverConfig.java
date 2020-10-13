package com.springbootselenium.springbootseleniumproject.config;

import com.springbootselenium.springbootseleniumproject.annotation.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

//@Lazy
//@Configuration
@LazyConfiguration
public class WebDriverConfig {

    //@Primary // This means its set as Primary Bean and when more than 1 Bean is found by Spring then this will be returned.
    @Bean
    //@ConditionalOnProperty(name="browser", havingValue = "chrome")
    public WebDriver chromeDriver()
    {
        WebDriverManager.chromedriver().driverVersion("85.0.4183.87").browserVersion("85.0.4183.121").setup();
        return new ChromeDriver();
    }

    @Bean
    //@ConditionalOnProperty(name="browser", havingValue = "firefox")
    //@ConditionalOnMissingBean
    //@Scope("prototype")
    @Scope("browserScope")
    public WebDriver firefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
