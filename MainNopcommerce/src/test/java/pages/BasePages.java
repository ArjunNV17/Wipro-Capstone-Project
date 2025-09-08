package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static String baseUrl;

    // Initialize driver and base URL
    public static void initializeDriver(String url) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            baseUrl = url;
        }
    }

    // Get WebDriver
    public static WebDriver getDriver() {
        return driver;
    }

    // Get WebDriverWait
    public static WebDriverWait getWait() {
        return wait;
    }

    // Get Base URL
    public static String getBaseUrl() {
        return baseUrl;
    }

    // Quit driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
            baseUrl = null;
        }
    }
}