@regression @OMT-7925
Feature:Etsy Application search and filter functionalities

    #Will run repeated steps that user has in each scenario
  # @Before method will run
  Background: Repeated first steps in each scenario
    Given user navigates to the Etsy application
    When user searches for "Carpet"

  Scenario: Validating price range filter functionality for search items
    And user applies price filter over 1000
    Then user validates the items price is equal or over 1000
    # @After method will run

    @OMT-7926

    Scenario: Validating search results
      Then user validates search result items contains keyword "carpet" or "rug"
      # @After method will run




