package com.test.googletranslate;

import com.test.googletranslate.pages.GoogleMainPage;
import com.test.googletranslate.pages.GoogleTranslatePage;
import com.test.googletranslate.pages.ResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GoogleTranslateTests {
    private WebDriver driver;
    private WebDriver driverForConcurrentSession = null;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        navigateToSite(driver, "https://www.google.com");
    }

    @After
    public void tearDown() {
        driver.quit();
        if (driverForConcurrentSession != null) driverForConcurrentSession.quit();
    }

    @Test
    public void searchResult() {
        searchRequestedPhrase(driver, "google translate");
        String linkEN = retrieveLinkToGoogleTranslate(driver);
        driverForConcurrentSession = new ChromeDriver();
        navigateToSite(driverForConcurrentSession, linkEN);
        String translation =
                getTextTranslation(driverForConcurrentSession, "English", "Polish", "luxoft test task");

        assertThat(translation, containsString("zadaniem testu"));
    }

    private String getTextTranslation(WebDriver driver,
                                      String from,
                                      String to,
                                      String text) {
        GoogleTranslatePage translator = new GoogleTranslatePage(driver);
        translator.chooseSourceAndTargetLanguage(from, to);
        return translator.getTranslation(text);
    }

    private void navigateToSite(WebDriver driver, String link) {
        driver.manage().window().maximize();
        driver.get(link);
    }

    private void searchRequestedPhrase(WebDriver driver, String requestedPhrase) {
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.search(requestedPhrase);
    }

    private String retrieveLinkToGoogleTranslate(WebDriver driver) {
        ResultsPage searchResult = new ResultsPage(driver);
        // Get link to Google Translate EN (not depends on localization)
        String link = searchResult.retrieveItemLinkFromResultsList();
        return link.replaceAll("(hl=)[a-z]+", "hl=en");
    }
}
