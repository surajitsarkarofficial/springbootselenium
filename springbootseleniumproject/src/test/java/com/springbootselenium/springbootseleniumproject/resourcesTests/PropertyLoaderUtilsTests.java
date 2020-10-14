package com.springbootselenium.springbootseleniumproject.resourcesTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoaderUtilsTests extends SpringBaseTestNGTests {

    @Autowired
    ResourceLoader loader;

    @Test
    public void propertyLoaderUtilsTests() throws IOException {
        Properties prop =PropertiesLoaderUtils.loadProperties(loader.getResource("classpath:properties/my.properties"));
        System.out.println(prop.get("username"));
        System.out.println(prop.get("password"));
    }

}
