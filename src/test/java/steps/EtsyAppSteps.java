package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchPage etsyAppSearchPage = new EtsyAppSearchPage();

    @Given("user navigates to the Etsy application")
    public void user_navigates_to_the_Etsy_application() {
        driver.get("https://www.etsy.com");

    }

    @When("user searches for {string}")
    public void user_searches_for(String itemName) {
        etsyAppHomePage.searchBox.sendKeys(itemName + Keys.ENTER);

    }

    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer price) {
        etsyAppSearchPage.allFiltersButton.click();
        etsyAppSearchPage.priceRadioButton.click();
        etsyAppSearchPage.applyButton.click();


    }

    @Then("user validates the items price is equal or over {double}")
    public void user_validates_the_items_price_is_equal_over(Integer price) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> prices = etsyAppSearchPage.prices;

        for (WebElement element : prices) {
            // System.out.println(element.getText());
            String priceStr = element.getText().replace(",", "");//"1,800.00"-> "1800.00"
            double doublePrice = Double.parseDouble(priceStr);
            System.out.println(doublePrice);
            Assert.assertTrue(doublePrice >= price);
        }

    }

    @Then("user validates search result items contains keyword {string} or {string}")
    public void userValidatesSearchResultItemsContainsKeyword(String item1, String item2) {
        List<WebElement> itemNames = etsyAppSearchPage.itemNames;

        for (int i = 0; i < itemNames.size(); i++) {
            String newItemNames = itemNames.get(i).getText();
            boolean condition = newItemNames.toLowerCase(Locale.ROOT).contains(item1) || newItemNames.toLowerCase(Locale.ROOT).contains(item2);
            if (condition) {
                StringBuilder str = new StringBuilder();
                str.append(newItemNames);

                System.out.println(str);
                Assert.assertTrue(str.toString().toLowerCase(Locale.ROOT).contains(item1) || str.toString().toLowerCase(Locale.ROOT).contains(item2));

            }
        }
    }
    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {
        if (section.equals("Mother's Day Gift")) {
            etsyAppHomePage.mothersDayGift.click();
        }else if(section.equalsIgnoreCase("Jewelry and Accessories")) {
            etsyAppHomePage.jewelryAndAccessories.click();
        }else if(section.equalsIgnoreCase("Clothing and Shoes")) {
            etsyAppHomePage.clothingAndAccessories.click();
        }else if(section.equalsIgnoreCase("Home and Living")) {
            etsyAppHomePage.homeAndLiving.click();
        }else if(section.equalsIgnoreCase("Wedding and Party")) {
            etsyAppHomePage.weddingAndParty.click();
        }else if(section.equalsIgnoreCase("Toys and Entertainment")) {
            etsyAppHomePage.toysAndEntertainment.click();
        }else if(section.equalsIgnoreCase("Art and Collectibles")) {
            etsyAppHomePage.artAndCollectibles.click();
        }else if(section.equalsIgnoreCase("Craft and Supplies and Tools")) {
            etsyAppHomePage.craftAndSupplies.click();
        }else if(section.equalsIgnoreCase("Gifts and Gift Cards")) {
            etsyAppHomePage.giftsAbdGiftCards.click();
        }

    }

    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    }
