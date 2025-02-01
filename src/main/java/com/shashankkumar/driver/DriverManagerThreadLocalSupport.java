package com.shashankkumar.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.net.MalformedURLException;
import java.util.Objects;

public class DriverManagerThreadLocalSupport {
   public  static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

   public static void setDriver(WebDriver refDriver){
       dr.set(refDriver);

   }

   public static WebDriver getDriver(){
       return dr.get();
   }

   //Unload

    public static void unload(){
       dr.remove();
    }
    //When we want to Start the Browser

    public static void init() throws MalformedURLException {
       if(Objects.isNull(DriverManagerThreadLocalSupport.getDriver())){
           ChromeOptions chromeOptions =new ChromeOptions();
           chromeOptions.addArguments("--guest");
           chromeOptions.addArguments("--remote-allow-origins=*");

           WebDriver driver = new ChromeDriver(chromeOptions);
           setDriver(driver);
       }

    }

    // When we want to close the browser

    public static void down(){

        if(Objects.nonNull(DriverManagerThreadLocalSupport.getDriver())){
            getDriver().quit();
            unload();
        }
    }
}
