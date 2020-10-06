package com.springbootselenium.springbootseleniumproject.googleTests.scope;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.testng.annotations.Test;

public class JuniorSeniorTests extends SpringBaseTestNGTests {

    @Autowired
    private JuniorEngg junior;

    @Autowired
    private SeniorEngg senior;

    @Test
    public void test1()
    {
        junior.setSalary(100);
        System.out.println("Junior "+ junior.getSalary().getAmount());
        senior.setSalary(200);
        System.out.println("Senior "+ senior.getSalary().getAmount());
        System.out.println("Junior "+ junior.getSalary().getAmount());
    }
}
