package com.springbootselenium.springbootseleniumproject.page.switchWindowUsingAOP;

import com.springbootselenium.springbootseleniumproject.core.annotation.Window;
import com.springbootselenium.springbootseleniumproject.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class AOPPageC extends Base {

    @FindBy(id="area")
    private WebElement textArea;

    public void addToArea(String msg)
    {
        this.textArea.sendKeys(msg);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAt() {
        return wait.until(d->this.textArea.isDisplayed());
    }
}
