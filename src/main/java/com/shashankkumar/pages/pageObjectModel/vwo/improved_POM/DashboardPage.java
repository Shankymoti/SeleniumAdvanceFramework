package com.shashankkumar.pages.pageObjectModel.vwo.improved_POM;

import com.shashankkumar.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPages {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameOnDashboard = By.xpath("//*[@data-qa='lufexuloga']");

    public String loggedInUserName(){

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return driver.findElement(usernameOnDashboard).getText();
        presenceOfWebElement(usernameOnDashboard);
        return getText(usernameOnDashboard);

    }
}
