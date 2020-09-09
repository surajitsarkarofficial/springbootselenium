package com.springbootselenium.springbootseleniumproject.page.google;

import com.springbootselenium.springbootseleniumproject.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class SearchResults  extends Base {

    @FindBy(css="div.rc")
    private List<WebElement> results;

    public int getCount()
    {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }
}
