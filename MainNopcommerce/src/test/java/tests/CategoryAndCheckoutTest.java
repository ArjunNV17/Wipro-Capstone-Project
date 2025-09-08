package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePages;

public class CategoryAndCheckoutTest {
    private static int stepCounter;
    private static final Logger logger = LogManager.getLogger(CategoryAndCheckoutTest.class);

    @BeforeClass
    @Parameters("baseUrl")
    public void setUp(String baseUrl) {
        stepCounter = 1;
        logStep("Launching browser and setting base URL: " + baseUrl);
        BasePages.initializeDriver(baseUrl);
    }

    @BeforeMethod
    public void goToHomePage() {
        logStep("Navigating to home page");
        BasePages.getDriver().get(BasePages.getBaseUrl());
    }

    protected void logStep(String message) {
        logger.info("Step " + stepCounter++ + ": " + message);
       }
    @AfterClass
    public void tearDown() {
        logStep("Closing browser after completing checkout");
        BasePages.quitDriver();

    }

    // ======== Add Products ========
    @Test(priority = 3)
    public void addComputerProduct() {
        logStep("Clicking on Computers");
        BasePages.getDriver().findElement(By.linkText("Computers")).click();
        BasePages.getDriver().findElement(By.linkText("Desktops")).click();
        BasePages.getDriver().findElement(By.linkText("Build your own computer")).click();

        new Select(BasePages.getDriver().findElement(By.id("product_attribute_1")))
                .selectByVisibleText("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
        new Select(BasePages.getDriver().findElement(By.id("product_attribute_2")))
                .selectByVisibleText("8GB [+$60.00]");
        BasePages.getDriver().findElement(By.id("product_attribute_3_7")).click();
        BasePages.getDriver().findElement(By.id("product_attribute_4_9")).click();
        BasePages.getDriver().findElement(By.id("product_attribute_5_12")).click();

        BasePages.getDriver().findElement(By.id("add-to-cart-button-1")).click();
    
    }

    @Test(priority = 4)
    public void addElectronicsProduct() {
        logStep("Clicking on Electronics");
        BasePages.getDriver().findElement(By.linkText("Electronics")).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Cell phones"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("HTC One Mini Blue"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-19"))).click();
     
    }

    @Test(priority = 5)
    public void addApparelProduct() {
        logStep("Clicking on Apparel");
        BasePages.getDriver().findElement(By.linkText("Apparel")).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Shoes"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.linkText("adidas Consortium Campus 80s Running Shoes"))).click();
        WebElement sizeDropdown = BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("product_attribute_9")));
        new Select(sizeDropdown).selectByVisibleText("9");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-27"))).click();
      
    }

    @Test(priority = 6)
    public void addDigitalDownloadProduct() {
        logStep("Clicking on Digital downloads");
        BasePages.getDriver().findElement(By.linkText("Digital downloads")).click();
        BasePages.getDriver().findElement(By.cssSelector(".product-title a")).click();
        BasePages.getDriver().findElement(By.cssSelector("button.add-to-cart-button")).click();
     
    }

    @Test(priority = 7)
    public void addBooksProduct() {
        logStep("Clicking on Books");
        BasePages.getDriver().findElement(By.linkText("Books")).click();
        BasePages.getDriver().findElement(By.cssSelector(".product-title a")).click();
        BasePages.getDriver().findElement(By.cssSelector("button.add-to-cart-button")).click();
     
    }

    @Test(priority = 8)
    public void addJewelryRentalProduct() {
        logStep("Clicking on Jewelry");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Jewelry"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Elegant Gemstone Necklace (rental)"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("rental_start_date_42"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='10']"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("rental_end_date_42"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='20']"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-42"))).click();
     
    }

    @Test(priority = 9)
    public void addVirtualGiftCardProduct() {
        logStep("Clicking on Gift Cards");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Gift Cards"))).click();
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("$25 Virtual Gift Card"))).click();
        BasePages.getDriver().findElement(By.id("giftcard_45_RecipientName")).sendKeys("Alice Recipient");
        BasePages.getDriver().findElement(By.id("giftcard_45_RecipientEmail")).sendKeys("alice@example.com");
        BasePages.getDriver().findElement(By.id("giftcard_45_SenderName")).sendKeys("Bob Sender");
        BasePages.getDriver().findElement(By.id("giftcard_45_SenderEmail")).sendKeys("bob@example.com");
        BasePages.getDriver().findElement(By.id("add-to-cart-button-45")).click();
      
    }

    // ======== Checkout All Products ========
    @Test(priority = 10)
    public void checkoutAllProducts() {
        logStep("Opening Shopping Cart");
        BasePages.getDriver().findElement(By.cssSelector("span.cart-label")).click();

        logStep("Accepting Terms of Service");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("termsofservice"))).click();

        logStep("Clicking Checkout");
        BasePages.getDriver().findElement(By.id("checkout")).click();

        logStep("Choosing Guest Checkout");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.checkout-as-guest-button"))).click();

        logStep("Filling Billing Address");

        // Country selection
        WebElement countryDropdown = BasePages.getWait().until(
                ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_CountryId"))
        );
        new Select(countryDropdown).selectByVisibleText("United States of America");

        // Dynamic State handling
        WebElement stateField = BasePages.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_StateProvinceId"))
        );
        if (stateField.getTagName().equals("select")) {
            new Select(stateField).selectByIndex(1);
        } else {
            stateField.clear();
            stateField.sendKeys("New York");
        }

        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_FirstName"))).sendKeys("John");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_LastName"))).sendKeys("Doe");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_Email"))).sendKeys("johndoe@example.com");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_City"))).sendKeys("New York");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_Address1"))).sendKeys("123 Main St");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_ZipPostalCode"))).sendKeys("10001");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(By.id("BillingNewAddress_PhoneNumber"))).sendKeys("1234567890");

        logStep("Clicking Next on Billing Address");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.new-address-next-step-button"))).click();

        logStep("Selecting Shipping Method");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.shipping-method-next-step-button"))).click();

        logStep("Selecting Payment Method");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.payment-method-next-step-button"))).click();

        logStep("Filling Payment Information");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.payment-info-next-step-button"))).click();

        logStep("Confirming Order");
        BasePages.getWait().until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.confirm-order-next-step-button"))).click();

        logStep("Verifying Order Confirmation");
        WebElement confirmation = BasePages.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section.order-completed"))
        );
        Assert.assertTrue(confirmation.getText().contains("Your order has been successfully processed!"));

        logStep("Checkout completed successfully");
    }
}