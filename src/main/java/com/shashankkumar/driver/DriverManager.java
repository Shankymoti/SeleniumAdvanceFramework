package com.shashankkumar.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesReader;

import java.util.Locale;

public class DriverManager {
    public static WebDriver driver;
/*
getDriver() → Returns the current WebDriver instance.
setDriver(WebDriver driver) → Assigns a WebDriver instance to the global variable.
 */
    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver = driver;
    }

    //When we want to Start the Browser

    public static void init(){
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if(driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--guest");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    System.out.println("Not a Browser found");
            }
        }
    }

    // When we want to close the browser

    public static void down(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
