package com.springbootselenium.springbootseleniumproject.config;

import com.springbootselenium.springbootseleniumproject.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//@Lazy
//@Configuration
@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    public int timeout;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver)
    {
        return new WebDriverWait(driver,timeout);
    }
}
