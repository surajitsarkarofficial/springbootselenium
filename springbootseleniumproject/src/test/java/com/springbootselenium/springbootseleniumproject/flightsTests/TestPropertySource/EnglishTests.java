package com.springbootselenium.springbootseleniumproject.flightsTests.TestPropertySource;

import com.springbootselenium.springbootseleniumproject.flightsTests.FlightsTests;
import org.springframework.test.context.TestPropertySource;

/**
 * Executing the tests in english language property file and default browser
 */
@TestPropertySource(properties={"flights.app.lang=english"})
public class EnglishTests extends FlightsTests {
}
