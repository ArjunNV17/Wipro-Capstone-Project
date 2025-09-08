package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    // Accurate locators according to page
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By company = By.id("Company");
    private By newsletter = By.id("Newsletter");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectGender(String gender) {
        if ("Male".equalsIgnoreCase(gender)) {
            driver.findElement(genderMale).click();
        } else {
            driver.findElement(genderFemale).click();
        }
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailAddr) {
        driver.findElement(email).sendKeys(emailAddr);
    }

    public void enterCompany(String comp) {
        driver.findElement(company).sendKeys(comp);
    }

    public void setNewsletterSubscription(String choice) {
        WebElement cb = driver.findElement(newsletter);
        boolean selected = cb.isSelected();
        if ("Yes".equalsIgnoreCase(choice) && !selected) {
            cb.click();
        } else if ("No".equalsIgnoreCase(choice) && selected) {
            cb.click();
        }
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }
}