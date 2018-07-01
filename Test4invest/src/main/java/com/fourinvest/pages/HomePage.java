package com.fourinvest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kengoroo on 12.11.2015.
 */
public class HomePage {
    @FindBy(id = "button-1013-btnEl")
    private WebElement nameBtn;

    @FindBy(id = "menuitem-1015-itemEl")
    private WebElement profileBtn;

    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToProfile(){
        nameBtn.click();
        profileBtn.click();
    }

    public boolean isNameBtn(){
        return nameBtn.isDisplayed();
    }
}