package com.springbootselenium.springbootseleniumproject.resourcesTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.resourcesTests.propertyMapper.MyPropertiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.testng.annotations.Test;

public class PropertySourceTests extends SpringBaseTestNGTests {

    @Autowired
    MyPropertiesMapper data;

    @Test
    public void test1()
    {
        System.out.println(data.getuName());
        System.out.println(data.getPassword());
    }

}
