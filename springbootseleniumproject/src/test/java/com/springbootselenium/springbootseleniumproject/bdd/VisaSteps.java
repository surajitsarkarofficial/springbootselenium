package com.springbootselenium.springbootseleniumproject.bdd;

import com.springbootselenium.springbootseleniumproject.flightsTests.propertyMapper.FlightsDataMapper;
import com.springbootselenium.springbootseleniumproject.page.flights.FlightSearch;
import com.springbootselenium.springbootseleniumproject.page.visa.VisaRegistrationPage;
import com.springbootselenium.springbootseleniumproject.repositories.UserRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.time.LocalDate;

public class VisaSteps {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    VisaRegistrationPage registrationPage;


    @Given("I am on visa registration form")
    public void launchSite() {
        this.registrationPage.goTo();
    }

    @When("I select my from country {string} and to country {string}")
    public void selectFromAndToCountry(String fCountry, String tCounty) {

        this.registrationPage.setCountryFromAndTo(fCountry,tCounty);
    }

    @And("I enter my dob as {string}")
    public void enterDOB(String dob) {
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void enterName(String fName, String lName) {
        this.registrationPage.setNames(fName,lName);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phn) {

        this.registrationPage.setContactDetails(email,phn);
    }

    @And("I enter the comment as {string}")
    public void enterComments(String comments) {
        this.registrationPage.setComments(comments);
    }

    @And("I submit he form")
    public void sumbitForm() {
        this.registrationPage.submit();
    }

    @Then("I should get the confirmation number")
    public void verifyConfirmationNumber() {
        Assert.assertTrue(!this.registrationPage.getConfirmationNumber().isEmpty());
    }
}
