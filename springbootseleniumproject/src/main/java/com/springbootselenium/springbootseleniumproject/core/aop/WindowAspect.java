package com.springbootselenium.springbootseleniumproject.core.aop;

import com.springbootselenium.springbootseleniumproject.core.annotation.Window;
import com.springbootselenium.springbootseleniumproject.core.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    WindowSwitchService windowSwitchService;

    @Before("@target(window) && within(com.springbootselenium.springbootseleniumproject..*)")
    public void before(Window window)
    {
        this.windowSwitchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.springbootselenium.springbootseleniumproject..*)")
    public void after(Window window)
    {
        //Switch back to original window
        this.windowSwitchService.switchByIndex(0);
    }
}
