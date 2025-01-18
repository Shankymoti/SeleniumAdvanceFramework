package com.shashankkumar.tests.sample;

import com.shashankkumar.base.CommonToAllTest;
import com.shashankkumar.driver.DriverManager;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.DashboardPage;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;
import utils.UtilsExcel;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_DDT_POM_DM extends CommonToAllTest {

    @Owner("Shashank")
    @Description("To Verify that invalid creds give Error Message")
    @Test(dataProvider="getData", dataProviderClass = UtilsExcel.class)
    public void testLoginNegativeVWO(String name, String pwd){
        //WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo =  new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_vwo.loginVWOLoginInvalidCreds(name,pwd);

        //AssertJ
        assertThat(error_msg).isNotEmpty().isNotBlank().isNotNull();

        //TestNg Assert
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
    }

    @Owner("Shashank")
    @Description("To Verify that valid creds dashboard page loaded")
    @Test(dataProvider = "getData", dataProviderClass = UtilsExcel.class)
    public  void testLoginPositiveVWO(String name, String pwd){
      //  WebDriver driver = new ChromeDriver();
        LoginPage loginPage_vwo = new LoginPage(DriverManager.getDriver());
        loginPage_vwo.loginVWOLofinValidCreds(name,pwd);
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String loginUsername =  dashboardPage.loggedInUserName();

        assertThat(loginUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loginUsername,PropertiesReader.readKey("expected_username"));
    }
}
