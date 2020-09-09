package com.springbootselenium.springbootseleniumproject.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
@Lazy
@Configuration
public class WebDriverConfig {




    //@Primary // This means its set as Primary Bean and when more than 1 Bean is found by Spring then this will be returned.
    @Bean
    @ConditionalOnProperty(name="browser", havingValue = "chrome")// This is used when selection of Bean will be decided
    //based on value passed form property
    public WebDriver chromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    //@ConditionalOnProperty(name="browser", havingValue = "firefox")
    @ConditionalOnMissingBean // This means, if we have passed any value from property and it does not find any matching bean then this bean will be used.
    //The ordering of ConditionalOnMissingBean should be last.
    public WebDriver firefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}