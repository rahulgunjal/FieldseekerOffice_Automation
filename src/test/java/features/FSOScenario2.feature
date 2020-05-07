Feature: FS Office verify Configuration Tools then Mosquito species enteries
    User is able to Login in to the site and veryfi Mosquito species enteries

  @FSOS2
  Scenario: User verify Mosquito species tables entries
    Given user is  on loginpage and navigates to SignIn Page
    When user navigates to Configuration Tools then Select Mosquito species
    Then Calculate the number of enteries in table and Verify all the no of entries
