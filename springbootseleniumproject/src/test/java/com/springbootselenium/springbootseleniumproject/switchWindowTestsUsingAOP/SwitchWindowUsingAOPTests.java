package com.springbootselenium.springbootseleniumproject.switchWindowTestsUsingAOP;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.core.service.WindowSwitchService;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.MainPage;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.PageA;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.PageB;
import com.springbootselenium.springbootseleniumproject.page.switchWindow.PageC;
import com.springbootselenium.springbootseleniumproject.page.switchWindowUsingAOP.AOPMainPage;
import com.springbootselenium.springbootseleniumproject.page.switchWindowUsingAOP.AOPPageA;
import com.springbootselenium.springbootseleniumproject.page.switchWindowUsingAOP.AOPPageB;
import com.springbootselenium.springbootseleniumproject.page.switchWindowUsingAOP.AOPPageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(properties={"browser=chrome"})
public class SwitchWindowUsingAOPTests extends SpringBaseTestNGTests {

    @Autowired
    private AOPMainPage mainPage;

    @Autowired
    private AOPPageA pageA;

    @Autowired
    private AOPPageB pageB;

    @Autowired
    private AOPPageC pageC;


    @BeforeClass
    public void beforeClass()
    {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchWithAOPTest()
    {
        this.pageA.addToArea("Hi from page A");
        this.pageB.addToArea("Hi from page B");
        this.pageC.addToArea("Hi from page C");
    }
}
