Feature: Facebook Login page.

  @Regression
  Scenario Outline: Login functionality
    Given I am on "facebook" page
    When I user type "<username>" and "<password>"
    Then I click submit button

    Examples:
   |username|password|
   |rupollbabu|206319 |