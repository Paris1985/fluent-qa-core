package com.fluent.qa.core;


import com.fluent.qa.core.browser.IBrowser;
import com.fluent.qa.core.utils.PropertyUtil;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.grid.config.ConfigException;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest extends FluentCucumberTest {
    private PropertyUtil propertyUtil = new PropertyUtil();


    @Override
    public WebDriver newWebDriver() {

        setWebDriverPath();
        return createWebDriver();

    }

    private WebDriver createWebDriver() {
        String remoteDriverEnabled = propertyUtil.getProperty("gridEnabled");
        if(remoteDriverEnabled.equals("true")){
            return runRemoteWebDriver();
        }else {
            return runWebDriver();
        }
    }

    private void setWebDriverPath() {
       // System.setProperty("webdriver.edge.driver", getDriverPath());
    }

    private String getDriverPath() {
        String driverPath  = null;
        switch (getWebDriver()) {
            case "edge":
                //Support Windows for now
                driverPath = "/drivers/msedgedriver.exe";
        }
        String path = this.getClass().getResource(driverPath).getPath();
        return path;
    }

    private WebDriver runRemoteWebDriver() {
        try {
            return new Augmenter().augment(
                    new RemoteWebDriver(new URL("http://localhost:4444/"), getBrowser().getCapabilities()));
        } catch (MalformedURLException e) {
            throw new ConfigException("Invalid hub location: " + getRemoteUrl(), e);
        }
    }

    private WebDriver runWebDriver() {
        switch (getWebDriver()) {
            case "edge":
               return new EdgeDriver((EdgeOptions) getBrowser().getCapabilities());
            default:
               return null;
        }
    }

    private IBrowser getBrowser() {
        return IBrowser.getBrowser(getWebDriver());
    }


}