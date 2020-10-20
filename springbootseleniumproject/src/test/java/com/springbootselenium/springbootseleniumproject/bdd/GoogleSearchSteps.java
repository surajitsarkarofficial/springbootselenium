package com.springbootselenium.springbootseleniumproject.bdd;

import com.springbootselenium.springbootseleniumproject.core.annotation.LazyAutowired;
import com.springbootselenium.springbootseleniumproject.page.google.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
public class GoogleSearchSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void launchWebsite() {
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @And("And I click on search button")
    public void clickSubmit() {
        Assert.assertTrue(this.googlePage.getSearchResults().isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResults(int count) {
        Assert.assertTrue(this.googlePage.getSearchResults().getCount()>=count);
    }
}
