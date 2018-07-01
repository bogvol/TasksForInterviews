package com.fourinvest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kengoroo on 12.11.2015.
 */
public class LogInPage {
    @FindBy(id = "textfield-1782-inputEl")
    private WebElement loginField;

    @FindBy(id = "textfield-1783-inputEl")
    private WebElement passwordField;

    @FindBy(id = "button-1787-btnInnerEl")
    private WebElement loginBtn;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logIn(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}
