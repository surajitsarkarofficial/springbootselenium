package com.springbootselenium.springbootseleniumproject.page.visa;

import com.springbootselenium.springbootseleniumproject.core.annotation.Page;
import com.springbootselenium.springbootseleniumproject.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Objects;

@Page
public class VisaRegistrationPage extends Base {

    @FindBy(id="first_4")
    private WebElement firstName;

    @FindBy(id="last_4")
    private WebElement lastName;

    @FindBy(id="input_46")
    private WebElement fromCountry;

    @FindBy(id="input_47")
    private WebElement toCountry;

    @FindBy(id="input_24_month")
    private WebElement month;

    @FindBy(id="input_24_day")
    private WebElement day;

    @FindBy(id="input_24_year")
    private WebElement year;

    @FindBy(id="input_6")
    private WebElement email;

    @FindBy(id="input_27_phone")
    private WebElement phone;

    @FindBy(id="input_45")
    private WebElement comments;

    @FindBy(id="submitBtn")
    private WebElement submit;

    @FindBy(id="requestnumber")
    private WebElement requestNumber;

    private static final Logger logger = LoggerFactory.getLogger(VisaRegistrationPage.class);

    public void goTo()
    {
        logger.info("Launching URL...");
        this.driver.get("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
    }

    public void setNames(String firstName,String lastName)
    {
        logger.info("Entering name...");
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }


    public void setCountryFromAndTo(String countryFrom, String countryTo){

        logger.info("Setting From and To Country..");
        new Select(this.fromCountry).selectByValue(countryFrom);
        new Select(this.toCountry).selectByValue(countryTo);

    }

    public void setBirthDate(LocalDate localDate)
    {
        logger.info("Entering DOB...");
        new Select(this.year).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(this.month).selectByValue(localDate.getMonth().toString());
        new Select(this.day).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
    }

    public void setContactDetails(String email, String phone)
    {
        logger.info("Entering Contact Details...");
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
    }

    public void setComments(String comments)
    {
        logger.info("Entering Comments...");
        //Objects.toString() if the comments is null it will send ""
        this.comments.sendKeys(Objects.toString(comments,""));
    }

    public void submit()
    {
        logger.info("Submitting form...");
        this.submit.click();
    }

    public String getConfirmationNumber()
    {
        logger.info("Fetching confirmation number...");
        this.wait.until((d)->this.requestNumber.isDisplayed());
        return this.requestNumber.getText();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.firstName.isDisplayed());
    }
}
