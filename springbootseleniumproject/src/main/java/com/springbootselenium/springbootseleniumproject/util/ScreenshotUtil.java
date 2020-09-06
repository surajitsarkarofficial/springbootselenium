package com.springbootselenium.springbootseleniumproject.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Component
public class ScreenshotUtil {

    @Autowired
    private WebDriver driver;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenshot(String fileName) throws IOException {
        File sourceFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,path.resolve(fileName).toFile());
    }
}
