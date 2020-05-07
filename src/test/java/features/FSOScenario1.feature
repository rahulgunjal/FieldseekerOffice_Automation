Feature: Office login and Dashboard verify tabs
  Verify if user is able to Login in to the site and as well veryfi related tab data

  @FSOS1
  Scenario: Login as a FieldSeeker user and verify tabs
    Given user is  on loginpage
    When user navigates to SignIn Page
    #   And user enters username and Password
    Then Verify all the tabs are displayed successfully
