package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePages {

    // Locators
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginBtn = By.xpath("//button[@class='button-1 login-button']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    // Actions
    public void enterEmail(String emailId) {
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}