package com.test.googletranslate.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public GoogleMainPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void search(final String requestedPhrase) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(requestedPhrase);

        searchField.sendKeys(Keys.RETURN);
    }
}
