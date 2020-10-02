package com.springbootselenium.springbootseleniumproject.beanLifecycleDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBeanLifeCycle {

    @Autowired
    private Television tv;

    @Test
    public void test1()
    {
        this.tv.playMovie();
    }
}
