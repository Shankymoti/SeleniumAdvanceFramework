package com.shashankkumar.tests.vwoTestCases;

import com.shashankkumar.pages.pageObjectModel.vwo.normal.DashboardPage;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_04_POM_PropertiesReader {

    @Owner("Shashank")
    @Description("To Verify that invalid creds give Error Message")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo =  new LoginPage(driver);
        String error_msg = loginPage_vwo.loginVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        //AssertJ
        assertThat(error_msg).isNotEmpty().isNotBlank().isNotNull();

        //TestNg Assert
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
    }

    @Owner("Shashank")
    @Description("To Verify that valid creds dashboard page loaded")
    @Test
    public  void testLoginPositiveVWO(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo = new LoginPage(driver);
        loginPage_vwo.loginVWOLofinValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPage dashboardPage = new DashboardPage(driver);
        String loginUsername =  dashboardPage.loggedInUserName();

        assertThat(loginUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loginUsername,PropertiesReader.readKey("expected_username"));
    }
}
