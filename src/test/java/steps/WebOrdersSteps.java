package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.EtsyAppSearchPage;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebOrdersSteps {
    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage WebOrdersHomePage = new WebOrdersHomePage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();


    @Given("user navigates to the WebOrders application")
    public void user_navigates_to_the_WebOrders_application() {
        driver.get(ConfigReader.getProperty("WebOrdersURL"));


    }

    @When("user provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();

    }

    @Then("user validates error message Invalid Login or Password.")
    public void user_validates_application_is_logged_in() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders";

        Assert.assertEquals(expectedTitle, actualTitle);
        driver.quit();


    }


    @Then("user validates error message {string}")
    public void userValidatesErrorMessage(String errorMessage) {
        String actualMessage = webOrdersLoginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage, actualMessage);
    }

    @Then("user validates application is logged in")
    public void userValidatesApplicationIsLoggedIn() {

    }

    @When("user navigates to the Order module")
    public void user_navigates_to_the_Order_module() {
        WebOrdersHomePage.orderModule.click();

    }

    @When("user selects {string} product with {int}")
    public void user_selects_product_with(String product, Integer quantity) {
        BrowserUtils.selectDropDownByValue(webOrdersOrderPage.orderProductDropDown, product);
        webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderPage.quantityBox.sendKeys("quantity" + "" + Keys.ENTER);

    }

    @Then("user validates total is  calculated properly for quantity {int}")
    public void user_validates_total_is_calculated_properly_for_quantity(Integer quantity) {

        String pricePerUnit = webOrdersOrderPage.pricePerUnit.getAttribute("value");
        int expectedTotal = 0;

        String discountAmount = webOrdersOrderPage.discountBox.getAttribute("value");
        int discountAmountInt = Integer.parseInt(discountAmount);
        int pricePerUnitInt = Integer.parseInt(pricePerUnit);

        if (discountAmountInt == 0) {
            expectedTotal = quantity * pricePerUnitInt;
        } else {
            expectedTotal = quantity * pricePerUnitInt;
            expectedTotal = quantity * expectedTotal - expectedTotal * discountAmountInt / 100;
        }
        String actualTotalAmount = webOrdersOrderPage.totalBox.getAttribute("value");
        int actualTotal = Integer.parseInt(actualTotalAmount);
        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @When("user counts number of orders in table")
    public void user_counts_number_of_orders_in_table() {
        int numberOfRows = pages.WebOrdersHomePage.numberOfRows.size();
    }

    @When("user creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
        List<Map<String,Object>> data = dataTable.asMaps(String.class,Object.class);
       BrowserUtils.selectDropDownByValue(WebOrdersOrderPage.orderProductDropdown, data.get(0).get("product").toString());
       webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
       webOrdersOrderPage.quantityBox.sendKeys(data.get(0).get("quantity").toString());
       webOrdersOrderPage.name.sendKeys(data.get(0).get("name").toString());
       webOrdersOrderPage.street.sendKeys(data.get(0).get("street").toString());
       webOrdersOrderPage.city.sendKeys(data.get(0).get("city").toString());
       webOrdersOrderPage.state.sendKeys(data.get(0).get("state").toString());
       webOrdersOrderPage.zip.sendKeys(data.get(0).get("zip").toString());
       webOrdersOrderPage.visaCheckBox.click();
       webOrdersOrderPage.cardNumber.sendKeys(data.get(0).get("cc").toString());
       webOrdersOrderPage.expireDate.sendKeys(data.get(0).get("expire date").toString());
       webOrdersOrderPage.processButton.click();
    }

    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
        String actualMessage = webOrdersOrderPage.successMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user provides username {string}test\"")
    public void userProvidesUsernameTest(String arg0) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
}
