package com.shashankkumar.tests.vwoTestCases;

import com.shashankkumar.pages.pageObjectModel.vwo.normal.DashboardPage;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_POM {

    @Owner("Shashank")
    @Description("To Verify that invalid creds give Error Message")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo =  new LoginPage(driver);
        String error_msg = loginPage_vwo.loginVWOLoginInvalidCreds("admin@gmail.com","123");

        //AssertJ
        assertThat(error_msg).isNotEmpty().isNotBlank().isNotNull();

        //TestNg Assert
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
    }

    @Owner("Shashank")
    @Description("To Verify that valid creds dashboard page loaded")
    @Test
    public  void testLoginPositiveVWO(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo = new LoginPage(driver);
        loginPage_vwo.loginVWOLofinValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashboardPage = new DashboardPage(driver);
        String loginUsername =  dashboardPage.loggedInUserName();

        assertThat(loginUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loginUsername,"Aman");
    }
}
