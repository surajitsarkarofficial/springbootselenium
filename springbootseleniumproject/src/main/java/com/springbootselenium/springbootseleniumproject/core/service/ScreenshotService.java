package com.springbootselenium.springbootseleniumproject.core.service;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
@Lazy //This means that the Screenshot util will be constructed by Spring boot only when it is being used.
//@Component
@Service //Its nothing but Component.
// Spring boot just created a alias for Component to use it for classes which provides service.
public class ScreenshotService {

    //@Autowired
    //private WebDriver driver;

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    Faker faker;

    @PostConstruct
    public void init()
    {
        System.out.println("Screenshot utils post construct called....");
    }

    public void takeScreenshot() throws IOException {
        //File sourceFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        //Using application context
        File sourceFile = ((TakesScreenshot) this.ctx.getBean(WebDriver.class)).getScreenshotAs(OutputType.FILE);

        FileCopyUtils.copy(sourceFile,path.resolve(faker.name().fullName()+".png").toFile());
    }
}
