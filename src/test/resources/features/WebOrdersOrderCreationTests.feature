@OMT-7929
Feature: Validating calculate and order creation functionalities.

  Scenario Outline: Validating calculate functionality
    Given user navigates to the WebOrders application
    When user provides username "Tester" and password "test"
    And user navigates to the Order module
    And user selects "<product>" product with <quantity>
    Then user validates total is  calculated properly for quantity <quantity>

    Examples:
      | product     | quantity |
      | MyMoney     | 1        |
      | FamilyAlbum | 100      |
      | ScreenSaver | 55       |
      | MyMoney     | 20       |

    @OMT-7931
    Scenario: Validating create order functionality
    Given user navigates to the WebOrders application
    When user provides username "Tester and password "test"
    And user counts number of orders in table
    And user navigates to the Order module
    And user creates order with data
      | product | quantity | name     | street      | city    | state | zipcode | cc           | expire date |
      | MyMoney | 1        | John Doe | 123 My Road | Chicago | IL    | 12345   | 123412341234 | 12/22       |
    Then user validates success message "New order has been successfully added."