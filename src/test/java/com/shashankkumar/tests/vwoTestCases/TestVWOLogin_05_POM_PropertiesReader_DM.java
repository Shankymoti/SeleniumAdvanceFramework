package com.shashankkumar.tests.vwoTestCases;

import com.shashankkumar.base.CommonToAllTest;
import com.shashankkumar.driver.DriverManager;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.DashboardPage;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_05_POM_PropertiesReader_DM extends CommonToAllTest {

    @Owner("Shashank")
    @Description("To Verify that invalid creds give Error Message")
    @Test
    public void testLoginNegativeVWO(){
        //WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo =  new LoginPage(DriverManager.getDriver());
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
      //  WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo = new LoginPage(DriverManager.getDriver());
        loginPage_vwo.loginVWOLofinValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String loginUsername =  dashboardPage.loggedInUserName();

        assertThat(loginUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loginUsername,PropertiesReader.readKey("expected_username"));
    }
}
