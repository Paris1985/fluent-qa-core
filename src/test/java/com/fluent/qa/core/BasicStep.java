package com.fluent.qa.core;

import com.fluent.qa.core.page.JavadocPage;
import com.fluent.qa.core.page.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fluentlenium.core.annotation.Page;

public class BasicStep extends  BaseTest {


    @Page
    private MainPage mainPage;

    @Page
    private JavadocPage javadocPage;


    @Given(value = "Visit duckduckgo")
    public void visitFluentleniumCom() {
        goTo(mainPage)
                .typeSearchPhraseIn("Test")
                .submitSearchForm().assertIsPhrasePresentInTheResults("Test");
    }

    @When(value = "I search FluentLenium")
    public void visitFluentleniumJavadoc() {
        goTo(javadocPage)
                .verifyIfIsLoaded();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        this.before(scenario);
        System.out.println("BASIC STEP here");
    }

    @After
    public void afterScenario(Scenario scenario) {
        this.after(scenario);
    }
}
