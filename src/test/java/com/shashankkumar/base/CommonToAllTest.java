package com.shashankkumar.base;

import com.shashankkumar.driver.DriverManager;
import com.shashankkumar.driver.DriverManagerThreadLocalSupport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class CommonToAllTest {

    @BeforeMethod
    public void setup() throws MalformedURLException {
       // DriverManager.init();
        DriverManagerThreadLocalSupport.init();
    }

    @AfterMethod
    public void tearDown(){
      //  DriverManager.down();
         DriverManagerThreadLocalSupport.down();
    }
}
