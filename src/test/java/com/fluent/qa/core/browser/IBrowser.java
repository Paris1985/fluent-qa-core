package com.fluent.qa.core.browser;


import org.openqa.selenium.Capabilities;

import java.util.Map;

public interface IBrowser {


    Edge edge = new Edge();


    Map<String, IBrowser> browsers = Map.ofEntries(

            Map.entry("edge", edge),
            Map.entry("chrome", new Chrome())

    );

    Capabilities getCapabilities();


    static IBrowser getBrowser(String browserName) {
        return browsers.getOrDefault(browserName, edge);
    }

}