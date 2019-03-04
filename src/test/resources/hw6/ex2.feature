@UserTableInterface
  Feature: User Table Test

    Scenario: User Table Page test
      Given I open EPAM JDI site
      And I login as 'USER'
#      When I click on Service button in Header
#      And I click on 'USERTABLE' button in Service dropdown
#      Then 'USER_TABLE' page is opened
#      # TODO displayed IN Users Table on User Table Page
#      #fixed
#      And '6' NumberType Dropdowns are displayed in Users Table on User Table Page
#      And '6' User names are displayed in Users Table on User Table Page
#      And '6' Description images are displayed in Users Table on User Table Page
#      And '6' Description texts under images are displayed in Users Table on User Table Page
#      And '6' checkboxes are displayed in Users Table on User Table Page
#      And User table contains following values:
#        | Number | User             | Description                      |
#        | 1      | Roman            | Wolverine                        |
#        | 2      | Sergey Ivan      | Spider Man                       |
#        | 3      | Vladzimir        | Punisher                         |
#        | 4      | Helen Bennett    | Captain America some description |
#        | 5      | Yoshi Tannamuri  | Cyclope some description         |
#        | 6      | Giovanni Rovelli | Hulk some description            |
#      When I select 'vip' checkbox for 'SERGEY_IVAN'
#      Then 1 log row has 'Vip: condition changed to true' text in log section
#      When I click on dropdown in column Type for user 'ROMAN'
#      Then Droplist contains values
#        | Admin   |
#        | User    |
#        | Manager |
