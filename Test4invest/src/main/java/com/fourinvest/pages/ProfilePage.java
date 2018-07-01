package com.fourinvest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kengoroo on 12.11.2015.
 */
public class ProfilePage {
    @FindBy(name = "content")
    WebElement chooseFotoBtn;

    @FindBy(id = "button-2285-btnInnerEl")//(xpath = ".//*[text()='Загрузить']")
    WebElement loadBtn;

    public ProfilePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadFoto (String address){
        chooseFotoBtn.sendKeys(address);
    }

    public boolean isLoadBtn(){
        return loadBtn.isDisplayed();
    }
}