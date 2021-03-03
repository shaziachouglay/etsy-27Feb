Feature: Search for product


  Scenario: Search by keyword
    Given Sharon is searching for product on Etsy
    When she searches for 'Masks'
    Then she should only be shown product related to 'Mask'


    Scenario: Display product details
      Given Sharon performed a search for 'Mask'
      When she views the details for the first listed item
      Then the correct details for the listed item should be displayed