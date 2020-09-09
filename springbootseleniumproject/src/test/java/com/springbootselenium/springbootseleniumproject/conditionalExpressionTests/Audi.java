package com.springbootselenium.springbootseleniumproject.conditionalExpressionTests;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component

//@Qualifier("audi")
//The above annotation means this bean has been qualified with name audi and where we want to use this bean,
// we can call it using same qualifier name

@ConditionalOnExpression("${car.speed} >= 170")
//The above annotation means this bean will be returned if the car.speed form property is greater than 170
public class Audi implements Car{
    @Override
    public void run() {
        System.out.println("This is Audi. The speed is 180 mph.");
    }
}
