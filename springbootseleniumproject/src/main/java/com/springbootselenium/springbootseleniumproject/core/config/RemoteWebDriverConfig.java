package com.springbootselenium.springbootseleniumproject.core.config;

import com.springbootselenium.springbootseleniumproject.core.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.net.URL;

//@Lazy
//@Configuration
@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {


    @Value("${selenium.grid.url}")
    private URL remoteURL;

    //@Primary // This means its set as Primary Bean and when more than 1 Bean is found by Spring then this will be returned.
    @Bean
    @ConditionalOnProperty(name="browser", havingValue = "chrome")// This is used when selection of Bean will be decided
    //based on value passed form property
    public WebDriver remoteChromeDriver()
    {

        return new RemoteWebDriver(this.remoteURL, DesiredCapabilities.chrome());
    }

    @Bean
    //@ConditionalOnProperty(name="browser", havingValue = "firefox")
    @ConditionalOnMissingBean // This means, if we have passed any value from property and it does not find any matching bean then this bean will be used.
    //The ordering of ConditionalOnMissingBean should be last.
    public WebDriver remoteFirefoxDriver()
    {
        return new RemoteWebDriver(this.remoteURL, DesiredCapabilities.firefox());
    }


}
