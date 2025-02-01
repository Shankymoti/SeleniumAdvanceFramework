package com.shashankkumar.tests.vwoTestCases;

import com.shashankkumar.base.CommonToAllTest;
import com.shashankkumar.driver.DriverManagerThreadLocalSupport;
import com.shashankkumar.listners.RetryAnalyzer;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.DashboardPage;
import com.shashankkumar.pages.pageObjectModel.vwo.normal.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_08_Improved_POM_PropertiesReader_DM_Retry_TL extends CommonToAllTest {
// for log
private static final Logger logger = LogManager.getLogger(TestVWOLogin_08_Improved_POM_PropertiesReader_DM_Retry_TL.class);
    @Owner("Shashank")
    @Description("To Verify that invalid creds give Error Message")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginNegativeVWO(){
        logger.info("Starting Test cases | testLoginNegativeVWO");
        //WebDriver driver = new ChromeDriver();
       // LoginPage loginPage_vwo =  new LoginPage(DriverManager.getDriver());
        LoginPage loginPage_vwo = new LoginPage(DriverManagerThreadLocalSupport.getDriver());
        String error_msg = loginPage_vwo.loginVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        //AssertJ
        assertThat(error_msg).isNotEmpty().isNotBlank().isNotNull();
        logger.info("Asserting error msg");
        //TestNg Assert
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
        logger.info("End of Test Case : testLoginNegativeVWO");
    }

    @Owner("Shashank")
    @Description("To Verify that valid creds dashboard page loaded")
    @Test
    public  void testLoginPositiveVWO(){
        logger.info("Starting Test Case: testLoginPositiveVWO");
      //  WebDriver driver = new ChromeDriver();
       // LoginPage loginPage_vwo = new LoginPage(DriverManager.getDriver());
        LoginPage loginPage_vwo = new LoginPage(DriverManagerThreadLocalSupport.getDriver());
        loginPage_vwo.loginVWOLofinValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
       // DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManagerThreadLocalSupport.getDriver());
        String loginUsername =  dashboardPage.loggedInUserName();
        logger.info("Asserting username"+ " ActualUsername is "+loginUsername+"Expected username is "+PropertiesReader.readKey("expected_username"));
        assertThat(loginUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loginUsername,PropertiesReader.readKey("expected_username"));
        logger.info("End of Test case :  testLoginPositiveVWO");
    }

    @Owner("Shashank")
    @Description("To Verify that Invalid creds dashboard page loaded : Failed")
    @Test
    public  void testLoginPositiveFailedVWO(){
        logger.info("Starting Test Case: testLoginPositiveVWO");
        //  WebDriver driver = new ChromeDriver();
       // LoginPage loginPage_vwo = new LoginPage(DriverManager.getDriver());
        LoginPage loginPage_vwo = new LoginPage(DriverManagerThreadLocalSupport.getDriver());
        loginPage_vwo.loginVWOLofinValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
//        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManagerThreadLocalSupport.getDriver());
        String loginUsername =  dashboardPage.loggedInUserName();
        logger.info("Asserting username"+ " ActualUsername is "+loginUsername+"Expected username is "+PropertiesReader.readKey("expected_username"));
        assertThat(loginUsername).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(loginUsername,"Shashank");
        logger.info("End of Test case :  testLoginPositiveVWO");
    }
}
