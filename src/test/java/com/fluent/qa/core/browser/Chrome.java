package com.fluent.qa.core.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements IBrowser{
    @Override
    public Capabilities getCapabilities() {
        return new ChromeOptions();
    }

    @Override
    public String toString() {
        return "Chrome";
    }

}
