package com.springbootselenium.springbootseleniumproject.switchWindowTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.core.service.WindowSwitchService;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.MainPage;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.PageA;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.PageB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(properties={"browser=chrome"})
public class SwitchWindowTests extends SpringBaseTestNGTests {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeClass
    public void beforeClass()
    {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchTest()
    {
        this.switchService.switchByTitle("Page A");
        this.pageA.addToArea("Hi from page A");
        this.switchService.switchByIndex(2);
        this.pageA.addToArea("Hi from page B");
    }
}
