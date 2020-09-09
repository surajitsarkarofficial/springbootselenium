package com.springbootselenium.springbootseleniumproject.conditionalExpressionTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

public class CarTests extends SpringBaseTestNGTests {

    @Autowired

    //@Qualifier("audi")// This will return the bean with Qualifier name "audi"

    private Car car;

    @Test
    public void carTest1()
    {
        car.run();
    }
}
