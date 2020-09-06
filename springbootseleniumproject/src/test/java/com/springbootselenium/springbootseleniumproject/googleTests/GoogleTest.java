package com.springbootselenium.springbootseleniumproject.googleTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.page.google.GooglePage;
import com.springbootselenium.springbootseleniumproject.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringBaseTestNGTests {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenshotUtil screenshot;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResults().isAt());
        screenshot.takeScreenshot("GoogleTestSearchResult.png");
        Assert.assertTrue(this.googlePage.getSearchResults().getCount() > 1);
    }
}
