package com.springbootselenium.springbootseleniumproject.core.config;

import com.springbootselenium.springbootseleniumproject.core.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

//@Lazy
//@Configuration
@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    public int timeout;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webDriverWait(WebDriver driver)
    {
        return new WebDriverWait(driver,timeout);
    }
}
