package com.shashankkumar.tests.vwoTestCases.pageFactory;

import com.shashankkumar.base.CommonToAllTest;
import com.shashankkumar.driver.DriverManager;
import com.shashankkumar.pages.pageFactory.LoginPage_PF;
import com.shashankkumar.tests.vwoTestCases.TestVWOLogin_07_Improved_POM_PropertiesReader_DM_Retry;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_PF extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_07_Improved_POM_PropertiesReader_DM_Retry.class);

    @Owner("shashank")
    @Description("To verify error mes when user enter invalid creds via Page Factory")
    @Test
    public void testLoginVWONegative_PF(){
        logger.info("Start TC : testLoginVWONegative_PF");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));
        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
        String error_msg = loginPagePf.loginToVWOInvalidCreds();
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
        logger.info("End TC : testLoginVWONegative_PF");


    }

}
