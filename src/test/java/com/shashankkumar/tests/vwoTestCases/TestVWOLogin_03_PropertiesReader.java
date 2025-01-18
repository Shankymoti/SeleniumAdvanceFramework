package com.shashankkumar.tests.vwoTestCases;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

public class TestVWOLogin_03_PropertiesReader {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");


        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.navigate().to("https://app.vwo.com");
        driver.get(PropertiesReader.readKey("url"));


        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys(PropertiesReader.readKey("invalid_username"));


        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(PropertiesReader.readKey("invalid_password"));



        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);


        WebElement error_message = driver.findElement(By.className("notification-box-description"));

        Assert.assertEquals(error_message.getText(), PropertiesReader.readKey("error_message"));


        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null


    }

}