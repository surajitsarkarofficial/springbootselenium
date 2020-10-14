package com.springbootselenium.springbootseleniumproject.resourcesTests.propertyMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("properties/my.properties")
public class MyPropertiesMapper {

    @Value("${user.username}")
    private String uName;

    @Value("${user.password}")
    private String password;

    public String getuName() {
        return uName;
    }

    public String getPassword() {
        return password;
    }
}
