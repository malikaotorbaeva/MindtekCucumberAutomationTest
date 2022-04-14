@OMT-7932 @regression
Feature: Validating pizza application functionalities

  Scenario: Validating place order functionality
    Given user navigates to pizza order with data
      | Pizza        | Small 6 Slices - no toppings |
      | Toppings 1   | Mushrooms                    |
      | Toppings 2   | Extra cheese                 |
      | Quantity     | 1                            |
      | Name         | Patel Harsh                  |
      | Email        | patel@gmail.com              |
      | Phone        | 123456789                    |
      | Payment Type | Credit Card                  |
    Then user validates that order is created with success message "Thank you for your order! TOTAL: " "Small 6 slices - no toppings"

    #Map<String,Object>map = new HarshMap();
  #map.put("Pizza","small 6 slices - no toppings");
  #map.put("Toppings 1",Mushrooms)

  #ListOfMap = {[Pizza=Small 6 Slices - no toppings,Toppings 1=Mushrooms,Toppings 2=Extra cheese,Quantity=1,Name=Patel Harsh,Email=patel@gmail.com,Phone=123456789,Payment Type=Credit Card
  # [Pizza=Small 6 Slices - no toppings,Toppings 1=Mushrooms,Toppings 2=Extra cheese,Quantity=1,Name=Patel Harsh,Email=patel@gmail.com,Phone=123456789,Payment=Credit Card],
  # [Pizza=Small 6 Slices - no toppings,Toppings 1=Mushrooms,Toppings 2=Extra cheese,Quantity=1,Name=Patel Harsh,Email=patel@gmail.com,Phone=123456789,Payment=Credit Card]},

