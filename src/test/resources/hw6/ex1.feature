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
    #  When I click on 'SERVICE' subcategory in the header
#    Then Service dropdown menu in header displays following options
#    When I click on Service subcategory in the left section
#    Then Service dropdown in left section displays following options
##   TODO This page name is not readable
#    When I open "Different elements" page from header menu Service
#    Then Interface on Different elements page contains 4 checkboxes with forces of nature
#    And Interface on Different elements page contains 4 radio buttons with metals
#    And Interface on Different elements page contains color choice dropdown
#    And Interface on Different elements page contains 2 buttons
#    And Different elements page has a Right section
#    And Different elements page has a Left section
#    When I select 'WATER' checkbox with forces of nature on Different elements page
#    Then For 'WATER' checkbox there is a log row with corresponding status 'true'
#    When I select 'WIND' checkbox on Different elements page
#    Then For 'WIND' checkbox there is a log row with status 'true'
#    When I select 'SELEN' radio button
#    # TODO Is it possible combine current step with "Then For 'WIND' checkbox there is a log row with status 'true'"?
#    Then There is a log raw for 'SELEN' radio button
#    When I select 'YELLOW' from the color selection dropdown
#    # TODO Is it possible combine current step with "Then For 'WIND' checkbox there is a log row with status 'true'"?
#    Then There is a log raw for 'YELLOW' color dropdown
#    When I unselect 'WATER' checkbox with forces of nature on Different elements page
#    # What is the difference between below step and "Then For 'WIND' checkbox there is a log row with status 'true'"?
#    Then Log row For 'WATER' checkbox with status 'false'
#    When I unselect 'WIND' checkbox on Different elements page
#    Then Log row For 'WIND' checkbox with status 'false'
