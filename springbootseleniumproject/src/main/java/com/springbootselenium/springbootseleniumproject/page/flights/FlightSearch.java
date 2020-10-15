package com.springbootselenium.springbootseleniumproject.page.flights;

import com.springbootselenium.springbootseleniumproject.core.annotation.Page;
import com.springbootselenium.springbootseleniumproject.core.annotation.Screenshot;
import com.springbootselenium.springbootseleniumproject.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Page
public class FlightSearch extends Base {

    @FindBy(xpath = "//a[contains(@class,'gws-travel-header__nav-item')]/span[@class='gws-travel-header__nav-label']")
    List<WebElement> elements;


    @Override
    public boolean isAt() {
        return wait.until((d)-> ! this.elements.isEmpty());
    }

    public void goTo(final String url)
    {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    @Screenshot
    public List<String> getLabels()
    {
        LinkedList<String> labelList = new LinkedList<>();

        for(WebElement ele : elements)
        {
            labelList.add(ele.getText());
        }
        return labelList;
    }

}
