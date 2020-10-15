package com.springbootselenium.springbootseleniumproject.core.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WindowSwitchService {

    @Autowired
    ApplicationContext ctx;

    public void switchByTitle(String title)
    {
        WebDriver driver = this.ctx.getBean(WebDriver.class);

        Set<String> windowHandles = driver.getWindowHandles();
        boolean isWindowFound=false;
        for(String handle : windowHandles)
        {
            String currTitle =driver.switchTo().window(handle).getTitle();
            if(currTitle.startsWith(title))
            {
                isWindowFound=true;
                break;
            }
        }
        if(!isWindowFound)
        {
            throw new RuntimeException("No Such Window");
        }

    }

    public void switchByIndex(int index)
    {
        WebDriver driver = this.ctx.getBean(WebDriver.class);

        Set<String> windowHandles = driver.getWindowHandles();
        String[] handles = windowHandles.toArray(new String[0]);
        driver.switchTo().window(handles[index]);

    }

}
