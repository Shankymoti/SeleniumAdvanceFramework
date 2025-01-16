package com.shashankkumar.tests.orangeHR_TestCases;

import com.shashankkumar.pages.pageObjectModel.orangeHR.EmployeeListHomePage;
import com.shashankkumar.pages.pageObjectModel.orangeHR.LoginHRPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOrangeHR_POM {

    @Owner("Shashank")
    @Description("To Verify Orange HR Login")
    @Test
    public void testVerifyOrangeHRLogin(){
        WebDriver driver = new ChromeDriver();
        LoginHRPage loginHRPage = new LoginHRPage(driver);
        loginHRPage.logintoOrageHR("admin","Hacker@4321");

        EmployeeListHomePage employeeListHomePage = new EmployeeListHomePage(driver);
        String  dashboardTxt = employeeListHomePage.loginUsername();

        assertThat(dashboardTxt).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(dashboardTxt,"PIM");
    }
}
