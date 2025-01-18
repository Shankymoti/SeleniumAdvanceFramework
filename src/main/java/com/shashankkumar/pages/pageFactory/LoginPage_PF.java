package com.shashankkumar.pages.pageFactory;

import com.shashankkumar.base.CommonToAllPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;

public class LoginPage_PF extends CommonToAllPages {

    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//Page Locator
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signBtn;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    //Page Actions

    public String loginToVWOInvalidCreds(){
      //  openVWOUrl();
        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signBtn);
        custom_wait();
        return getText(error_message);
    }




}
