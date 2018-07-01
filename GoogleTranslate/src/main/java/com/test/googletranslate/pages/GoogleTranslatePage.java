package com.test.googletranslate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTranslatePage {

    private WebDriver driver;

    private WebElement sourceLanguageItem;

    private WebElement targetLanguageItem;

    @FindBy(xpath = "//*[@id='gt-sl-gms']")
    private WebElement sourceLanguageDropdownMenu;

    @FindBy(xpath = "//*[@id='source']")
    private WebElement sourceTextArea;

    @FindBy(xpath = "//*[@id='gt-tl-gms']")
    private WebElement targetLanguageDropdownMenu;

    @FindBy(xpath = ".//*[@id='result_box']/span")
    private WebElement targetTextArea;

    @FindBy(xpath = "//*[@id='gt-submit']")
    private WebElement translateButton;

    public GoogleTranslatePage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void chooseSourceAndTargetLanguage(final String sourceLanguage, final String targetLanguage) {
        chooseSourceLanguage(sourceLanguage);
        chooseTargetLanguage(targetLanguage);
    }

    public String getTranslation(final String text) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sourceTextArea)).sendKeys(text);

        translateButton.click();

        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(targetTextArea)).getText();
    }

    private void chooseSourceLanguage(String sourceLanguage) {
        sourceLanguageDropdownMenu.click();
        sourceLanguageItem = driver
                .findElement(By.xpath(".//*[@id='gt-sl-gms-menu']//div[contains(text(),'" + sourceLanguage + "')]"));
        sourceLanguageItem.click();
    }

    private void chooseTargetLanguage(String targetLanguage) {
        targetLanguageDropdownMenu.click();
        targetLanguageItem = driver
                .findElement(By.xpath(".//*[@id='gt-tl-gms-menu']//div[contains(text(),'" + targetLanguage + "')]"));
        targetLanguageItem.click();
    }
}
