package cucumber.stepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePages;

public class SearchAddToWishlistSteps {

    @Given("I am on the homepage")
    public void i_am_on_homepage() {
        BasePages.getDriver().get(BasePages.getBaseUrl());
    }

    @When("I search for {string}")
    public void i_search_for(String term) {
        WebElement searchBox = BasePages.getWait().until(
                ExpectedConditions.elementToBeClickable(By.name("q"))
        );
        searchBox.clear();
        searchBox.sendKeys(term);

        WebElement searchButton = BasePages.getWait().until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
        );
        searchButton.click();
    }

    @When("I add the first product to the wishlist")
    public void i_add_first_product_to_wishlist() {
        WebElement firstProduct = BasePages.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[contains(@class,'product-item')])[1]"))
        );

        WebElement wishlistButton = firstProduct.findElement(
                By.xpath(".//button[contains(@class,'add-to-wishlist-button')]")
        );

        BasePages.getWait().until(
                ExpectedConditions.elementToBeClickable(wishlistButton)
        ).click();
    }
}