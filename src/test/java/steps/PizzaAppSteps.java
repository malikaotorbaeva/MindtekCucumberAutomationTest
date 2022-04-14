package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Map;

public class PizzaAppSteps {
    WebDriver driver = Driver.getDriver();
    Map<Object, Object> data;
    PizzaAppPage pizzaAppPage = new PizzaAppPage();

    @Given("user navigates to pizza application")
    public void user_navigates_to_pizza_application() {
        driver.get(ConfigReader.getProperty("PizzaAppURL"));
    }

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) {
        data = dataTable.asMap(String.class, Object.class);
        // for (Object object:data.values()){
        //   System.out.println(object);
    }
    BrowserUtils.selectDropdownByValue(pizzaAppPage,pizza1Box, data.get("Pizza").toString());


    @Then("user validates that order is created with success message {string} {string}")
    public void user_validates_that_order_is_created_with_success_message(String string, String string2){

    }

    @Given("user navigates to pizza order with data")
    public void userNavigatesToPizzaOrderWithData() {
    }
}
