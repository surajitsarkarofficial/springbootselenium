package com.springbootselenium.springbootseleniumproject.visaTestsUsingDataJPA;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import com.springbootselenium.springbootseleniumproject.entity.User;
import com.springbootselenium.springbootseleniumproject.page.visa.VisaRegistrationPage;
import com.springbootselenium.springbootseleniumproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class UserVisaTests extends SpringBaseTestNGTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    VisaRegistrationPage registrationPage;

    @Test
    public void visaTest()
    {
        //System.out.println(this.userRepository.findAll().size());

        //this.userRepository.findById(85)
        //.ifPresent(u-> System.out.println(u.getFirstName()));;

        List<User> users = userRepository.findAll().stream().limit(3).collect(Collectors.toList());

        for(User u : users)
        {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(),u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(),u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(),u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            System.out.println(this.registrationPage.getConfirmationNumber());
        }
    }
}
