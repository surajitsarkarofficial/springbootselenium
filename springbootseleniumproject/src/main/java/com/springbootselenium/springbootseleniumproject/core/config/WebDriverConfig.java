package com.springbootselenium.springbootseleniumproject.core.config;

import com.springbootselenium.springbootseleniumproject.core.annotation.LazyConfiguration;
import com.springbootselenium.springbootseleniumproject.core.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

//@Lazy
//@Configuration
@LazyConfiguration
public class WebDriverConfig {

    //@Primary // This means its set as Primary Bean and when more than 1 Bean is found by Spring then this will be returned.
    //@Bean
    @ConditionalOnProperty(name="browser", havingValue = "chrome")
    @ThreadScopeBean//custom annotation which holds, @Bean and @Scope
    public WebDriver chromeDriver()
    {
        WebDriverManager.chromedriver().driverVersion("85.0.4183.87").browserVersion("85.0.4183.121").setup();
        return new ChromeDriver();
    }


    //@Bean
    //@ConditionalOnProperty(name="browser", havingValue = "firefox")
    @ConditionalOnMissingBean
    //@Scope("prototype")
    //@Scope("browserScope")
    @ThreadScopeBean//custom annotation which holds, @Bean and @
    public WebDriver firefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
