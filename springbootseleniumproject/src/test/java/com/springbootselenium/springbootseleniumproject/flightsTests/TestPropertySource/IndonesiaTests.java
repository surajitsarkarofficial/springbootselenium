package com.springbootselenium.springbootseleniumproject.flightsTests.TestPropertySource;

import com.springbootselenium.springbootseleniumproject.flightsTests.FlightsTests;
import org.springframework.test.context.TestPropertySource;

/**
 * Executing the tests in indonesia language property file and browser chrome
 */
@TestPropertySource(properties={"flights.app.lang=indonesia","browser=chrome"})
public class IndonesiaTests extends FlightsTests {
}
