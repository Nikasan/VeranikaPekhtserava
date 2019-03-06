@DifferentElementsInterface
Feature: Different Elements Page Test

  Scenario: Interface testing
    Given I open EPAM JDI site
    Then Browser title should be 'HOME_PAGE_TITLE'
    When I login as 'USER'
    Then Username should be 'USER'
    Then Home Page should have 4 benefit icons
    Then Home Page should have 4 texts under benefit icons
    Then Home Page should have title 'MAIN_HEADER_TITLE' and description 'MAIN_HEADER_TEXT'
    When I open Service dropdown from header
    Then Service dropdown menu in header displays options:
      | SUPPORT            |
      | DATES              |
      | COMPLEXTABLE       |
      | SIMPLETABLE        |
      | USERTABLE          |
      | TABLESANDPAGES     |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I click on Service subcategory in the left section
    Then Service dropdown in left section displays following options:
      | SUPPORT            |
      | DATES              |
      | COMPLEXTABLE       |
      | SIMPLETABLE        |
      | USERTABLE          |
      | TABLESANDPAGES     |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |
    When I open 'DIFFERENT_ELEMENTS' page from header menu Service
    Then Interface on Different elements page contains 4 checkboxes with forces of nature:
      | WATER |
      | EARTH |
      | WIND  |
      | FIRE  |
    And Interface on Different elements page contains 4 radio buttons with metals:
      | GOLD   |
      | SILVER |
      | BRONZE |
      | SELEN  |
    And Interface on Different elements page contains colors dropdown
    And Interface on Different elements page contains 2 buttons:
    |DAFAULT_BUTTON|
    |BUTTON        |
    And Different elements page has a Right section
    And Different elements page has a Left section
    When I select following checkboxes with forces of nature on Different elements page:
      | WATER |
      | WIND  |
    Then For each checkbox there is a log row with corresponding status
      | WATER | true |
      | WIND  | true |
    When I select 'SELEN' radio button
    Then There is a log raw for 'SELEN' radio button
    When I select 'YELLOW' from the color selection dropdown
    Then There is a log raw for 'YELLOW' color dropdown
    When I unselect checkboxes:
      | WATER |
      | WIND  |
    Then Following boxes are unchecked:
      | WATER |
      | WIND  |
