package com.springbootselenium.springbootseleniumproject.page.google;

import com.springbootselenium.springbootseleniumproject.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class SearchComponent extends Base {
    @FindBy(name="q")
    private WebElement searchBox;

    //@FindBy(name="btnk")
    //private List<WebElement> searchBtns;

    public void search(String keyword)
    {
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.ENTER);

//        this.searchBtns
//                .stream()
//                .filter(e -> e.isDisplayed() && e.isEnabled())
//                .findFirst()
//                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
