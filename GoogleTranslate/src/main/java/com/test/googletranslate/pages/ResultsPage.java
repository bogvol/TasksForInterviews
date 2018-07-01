package com.test.googletranslate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='rso']//h3/a[contains(@href,'translate.google.com')]")
    private WebElement resultEntry;

    public ResultsPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String retrieveItemLinkFromResultsList() {

        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(resultEntry)).getAttribute("href");
    }
}
