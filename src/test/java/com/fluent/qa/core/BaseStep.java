package com.fluent.qa.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseStep extends BaseTest{

    @Before(order = 1)
    public void before(Scenario scenario){
        System.out.println("BaseStep before...");
    }

    @After
    public void after(Scenario scenario){
        System.out.print("BaseStep after...");
    }
}
