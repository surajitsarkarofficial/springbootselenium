package com.springbootselenium.springbootseleniumproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    public WebDriverWait wait;

    @PostConstruct
    public void init()
    {
        PageFactory.initElements(this.driver,this);
    }

    public abstract boolean isAt();

}
