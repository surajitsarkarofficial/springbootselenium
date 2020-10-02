package com.springbootselenium.springbootseleniumproject.beanLifecycleDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLOutput;

@Component
public class Television {

    @Value("${tv.name:sony}")
    private String tvName;

    public Television()
    {
        System.out.println("Inside constructor tv name is " + this.tvName);
    }


    @PostConstruct
    public void postConstruct()
    {
        System.out.println("Inside PostConstruct tv name is : "+ this.tvName);
        System.out.println("Turning on the Tv...");
    }

    public void playMovie()
    {
        for(int i =1 ; i< 6; i++)
        {
            try{
                System.out.println("Playing Scene "+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    public void preDestroy()
    {
        System.out.println("Turning of the Tv...");
    }


}
