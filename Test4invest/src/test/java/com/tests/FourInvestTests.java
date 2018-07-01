package com.tests;

import com.fourinvest.pages.HomePage;
import com.fourinvest.pages.LogInPage;
import com.fourinvest.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kengoroo on 12.11.2015.
 */
public class FourInvestTests {
    private WebDriver driverForChrome;

    @BeforeMethod
    public void openWebPage() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driverForChrome = new ChromeDriver();
        driverForChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverForChrome.get("https://www.4invest.net/ru/");
    }

    @AfterMethod
    public void closeBrowser() {
        driverForChrome.quit();
    }

    // проверка на успешное залогинивание при позитивном тесте
    @Test(priority = 1)
    public void positiveLogIn() {
        LogInPage page = new LogInPage(driverForChrome);
        page.logIn("Tester", "tgbnhy777");
        HomePage home = new HomePage(driverForChrome);
        Assert.assertTrue(home.isNameBtn());
    }

    // проверка на успешное залогинивание при негативном тесте (неверный username)
    @Test(priority = 3)
    public void negativeLogIn() {
        LogInPage page = new LogInPage(driverForChrome);
        page.logIn("Tester2", "tgbnhy777");
        HomePage home = new HomePage(driverForChrome);
        Assert.assertTrue(home.isNameBtn());
    }

    // проверка на наличие кнопки "Загрузить" при позитивном тесте
    @Test(priority = 2)
    public void positiveLoadBtn(){
        LogInPage page = new LogInPage(driverForChrome);
        page.logIn("Tester", "tgbnhy777");
        HomePage home = new HomePage(driverForChrome);
        home.goToProfile();
        ProfilePage profile = new ProfilePage(driverForChrome);

        String localAddress = "C:/Users/Kengoroo/IdeaProjects/"; //нужно изменить для запуска на другой машине

        profile.loadFoto(localAddress + "Test4invest/src/main/resources/eye.jpg");
        Assert.assertTrue(profile.isLoadBtn());
    }

    // проверка на наличие кнопки "Загрузить" при негативном тесте (не выбрано фото)
    @Test(priority = 4)
    public void negativeLoadBtn(){
        LogInPage page = new LogInPage(driverForChrome);
        page.logIn("Tester", "tgbnhy777");
        HomePage home = new HomePage(driverForChrome);
        home.goToProfile();
        ProfilePage profile = new ProfilePage(driverForChrome);
        Assert.assertTrue(profile.isLoadBtn());
    }

}