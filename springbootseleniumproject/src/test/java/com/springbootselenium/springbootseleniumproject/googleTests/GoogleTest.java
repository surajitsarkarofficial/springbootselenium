package com.springbootselenium.springbootseleniumproject.googleTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.core.annotation.LazyAutowired;
import com.springbootselenium.springbootseleniumproject.page.google.GooglePage;
import com.springbootselenium.springbootseleniumproject.core.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringBaseTestNGTests {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshot;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        System.out.println("Google page Launched..");

        this.googlePage.getSearchComponent().search("Spring Boot");
        System.out.println("Google search test entered..");
        Assert.assertTrue(this.googlePage.getSearchResults().isAt());
        System.out.println("Google search results displayed..");
        Assert.assertTrue(this.googlePage.getSearchResults().getCount() > 1);
        System.out.println("Google search test completed..");
        this.screenshot.takeScreenshot();
        this.googlePage.closeBrowser();
    }
}
