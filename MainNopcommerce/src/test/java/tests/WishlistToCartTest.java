package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePages;

public class WishlistToCartTest {

    @BeforeClass
    @Parameters("baseUrl")
    public void setUp(String baseUrl) {
        BasePages.initializeDriver(baseUrl);
        BasePages.getDriver().get(baseUrl);
    }

    @Test
    public void testWishlistToCart() {
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

        BasePages.getDriver().findElement(By.id("add-to-wishlist-button-1")).click();

        WebElement wishlistLink = BasePages.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Wishlist")));
        wishlistLink.click();

        WebElement wishlistItem = BasePages.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Build your own computer")));
        Assert.assertTrue(wishlistItem.isDisplayed());

        BasePages.getDriver().findElement(By.name("addtocart")).click();
        BasePages.getDriver().findElement(By.name("addtocartbutton")).click();

        WebElement cartLink = BasePages.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping cart")));
        cartLink.click();

        WebElement cartItem = BasePages.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Build your own computer")));
        Assert.assertTrue(cartItem.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        BasePages.quitDriver();
    }
}