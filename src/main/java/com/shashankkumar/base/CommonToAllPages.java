package com.shashankkumar.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.time.Duration;

import static com.shashankkumar.driver.DriverManager.getDriver;
/*
It imports the static method getDriver() from the DriverManager class located in the package com.thetestingacademy.driver.
With this import, you can call getDriver() directly in your code without needing to prefix it with the class name
 DriverManager.
 */

public class CommonToAllPages {
    // If you want to call something before every Page Object Class call, Put your Code here");
    // Open File, Open Data Base Connection You can write code here

    public CommonToAllPages()
    {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void custom_wait(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void clickElement(By by){
            getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
           by.click();
    }

    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by,String key){
        by.sendKeys(key);
    }

    public String getText(By by){
       return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }

    public WebElement presenceOfWebElement(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation){
        return  new WebDriverWait(getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key){
        return getDriver().findElement(key);
    }
}
