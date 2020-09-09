package com.springbootselenium.springbootseleniumproject.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
@Lazy //This means that the Screenshot util will be constructed by Spring boot only when it is being used.
@Component
public class ScreenshotUtil {

    @Autowired
    private WebDriver driver;

    @Value("${screenshot.path}")
    private Path path;

    @PostConstruct
    public void init()
    {
        System.out.println("Screenshot utils post construct called....");
    }

    public void takeScreenshot(String fileName) throws IOException {
        File sourceFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,path.resolve(fileName).toFile());
    }
}
