package com.springbootselenium.springbootseleniumproject.flightsTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.flightsTests.propertyMapper.FlightsDataMapper;
import com.springbootselenium.springbootseleniumproject.page.flights.FlightSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightsTests extends SpringBaseTestNGTests {

    @Autowired
    FlightsDataMapper flightData;

    @Autowired
    FlightSearch flightSearchPage;


    @Test
    public void flightsTest()
    {
        flightSearchPage.goTo(this.flightData.getUrl());

        Assert.assertTrue(this.flightSearchPage.isAt());

        Assert.assertEquals(this.flightSearchPage.getLabels(),this.flightData.getLabels());
    }

}
