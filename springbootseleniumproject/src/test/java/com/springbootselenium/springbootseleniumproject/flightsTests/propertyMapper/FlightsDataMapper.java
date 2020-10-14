package com.springbootselenium.springbootseleniumproject.flightsTests.propertyMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("properties/flights/${flights.app.lang}.properties")
public class FlightsDataMapper {

    @Value("${app.url}")
    private String url;

    @Value("${labels}")
    private List<String> labels;

    public String getUrl() {
        return url;
    }

    public List<String> getLabels() {
        return labels;
    }
}
