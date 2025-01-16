package com.shashankkumar.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHomePage {
    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver){
        this.driver = driver;

    }

    // Locators

    private  By usernameOnDashBoard = By.xpath("//h6[normalize-space()='PIM']");

    public String loginUsername(){
        return driver.findElement(usernameOnDashBoard).getText();
    }
}
