package com.shashankkumar.pages.pageObjectModel.vwo.improved_POM;

import com.shashankkumar.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertiesReader;

public class LoginPage extends CommonToAllPages {


    WebDriver driver;

    public LoginPage(WebDriver driver){
    this.driver = driver;
    }
    // Page Class
    // Page Locator

    // Step 1 - Page Locator

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInBtn = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By singBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");


    //Step 2: Page Actions

    public String loginVWOLoginInvalidCreds(String user, String pwd){
       // driver.get(PropertiesReader.readKey("url"));
        // driver.findElement(username).sendKeys(user);
        //driver.findElement(password).sendKeys(pwd);
        //driver.findElement(signInBtn).click();
        //        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // String error_message_text = driver.findElement(error_message).getText();
        //return error_message_text;
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signInBtn);
        presenceOfWebElement(error_message);
        return getText(error_message);
    }

    public void loginVWOLofinValidCreds(String user, String pwd){
       /* driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInBtn).click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        */

        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signInBtn);
        custom_wait();
    }

}
