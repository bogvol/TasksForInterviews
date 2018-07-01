package com.test.core;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by Kengoroo on 12.11.2015.
 */
//
public class AvatarTest4invest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Kengoroo/IdeaProjects/Test4invest/src/main/resources/chromedriver.exe");
        WebDriver driverForChrome = new ChromeDriver();
        driverForChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverForChrome.get("https://www.4invest.net/ru/login.html");

        WebElement loginField = driverForChrome.findElement(By.id("textfield-1782-inputEl"));
        loginField.sendKeys("Tester");

        WebElement passwordField = driverForChrome.findElement(By.id("textfield-1783-inputEl"));
        passwordField.sendKeys("tgbnhy777");

        WebElement loginBtn = driverForChrome.findElement(By.id("button-1787-btnInnerEl"));
        loginBtn.click();

        WebElement nameBtn = driverForChrome.findElement(By.id("button-1013-btnEl"));
        nameBtn.click();

        WebElement profileBtn = driverForChrome.findElement(By.id("menuitem-1015-itemEl"));
        profileBtn.click();

        WebElement chooseFotoBtn = driverForChrome.findElement(By.name("content"));
        chooseFotoBtn.sendKeys("C:/Users/Kengoroo/IdeaProjects/Test4invest/src/main/resources/eye.jpg");

        WebElement loadBtn = driverForChrome.findElement(By.id("button-2285-btnInnerEl"));//xpath(".//*[text()='Загрузить']"));

        if (loadBtn.isDisplayed()){
            System.out.println("Test OK");
        } else {
            System.out.println("Test Failed");
        }

        driverForChrome.quit();
    }
}
