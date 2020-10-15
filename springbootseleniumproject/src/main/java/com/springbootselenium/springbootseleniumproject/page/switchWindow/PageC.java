package com.springbootselenium.springbootseleniumproject.page.switchWindow;

import com.springbootselenium.springbootseleniumproject.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageC extends Base {

    @FindBy(id="area")
    private WebElement textArea;

    public void addToArea(String msg)
    {
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return wait.until(d->this.textArea.isDisplayed());
    }
}
