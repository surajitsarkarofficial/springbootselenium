package com.springbootselenium.springbootseleniumproject.googleTests.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") //solution : prototypes creates fresh object for the bean for all.
public class Salary {

    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }




}
