package com.shashankkumar.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRPage {
    WebDriver driver;
    public LoginHRPage(WebDriver driver){
        this.driver = driver;

    }

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//*[contains(@class,'orangehrm-login-button')]");

    public void logintoOrageHR(String name, String pwd){
       driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
      try{
          Thread.sleep(5000);
      }catch (InterruptedException e){
          throw new RuntimeException(e);
      }
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginButton).click();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
