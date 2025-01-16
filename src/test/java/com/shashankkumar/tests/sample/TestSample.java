package com.shashankkumar.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample {


@Owner("Shashank")
@Description("To verify TC1")
@Test
public void testTC1(){
    Assert.assertTrue(true);
}

@Owner("Shashank")
@Description("To Verify TC2")
@Test
public void testTC2(){
    Assert.assertTrue(true);
}
}


