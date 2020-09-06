package com.springbootselenium.springbootseleniumproject.page.google;

import com.springbootselenium.springbootseleniumproject.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    @Autowired
    private SearchResults searchResults;

    @Value("${application.url}")
    private String url;

    public void goTo()
    {
        this.driver.get(url);
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
