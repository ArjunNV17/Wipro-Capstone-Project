package cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePages;

public class Hooks {

    @Before
    public void setUp() {
        BasePages.initializeDriver("https://demo.nopcommerce.com");
    }

    @After
    public void tearDown() {
        BasePages.quitDriver();
    }
}