package com.shashankkumar.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameOnDashboard = By.xpath("//*[@data-qa='lufexuloga']");

    public String loggedInUserName(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(usernameOnDashboard).getText();
    }
}
