package com.springbootselenium.springbootseleniumproject.googleTests.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JuniorEngg {

    @Autowired
    private Salary salary;

    public Salary getSalary()
    {
        return this.salary;
    }

    public void setSalary(int amount)
    {
        this.salary.setAmount(amount);
    }


}
