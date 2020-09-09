package com.springbootselenium.springbootseleniumproject.conditionalExpressionTests;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component

//@Qualifier("bmw")
//The above annotation means this bean has been qualified with name bmw and where we want to use this bean,
// we can call it using same qualifier name

@ConditionalOnExpression("${car.speed} < 170")
//The above annotation means this bean will be returned if the car.speed form property is less than 170

public class BMW implements Car{
    @Override
    public void run() {
        System.out.println("This is BMW . The Speed is 120 mph.");
    }
}
