package com.springbootselenium.springbootseleniumproject.core.aop;

import com.springbootselenium.springbootseleniumproject.core.annotation.Screenshot;
import com.springbootselenium.springbootseleniumproject.core.annotation.Window;
import com.springbootselenium.springbootseleniumproject.core.service.ScreenshotService;
import com.springbootselenium.springbootseleniumproject.core.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    ScreenshotService screenshotService;

    @After("@annotation(screenshot)")
    public void before(Screenshot screenshot) throws IOException {
        this.screenshotService.takeScreenshot();
    }


}
