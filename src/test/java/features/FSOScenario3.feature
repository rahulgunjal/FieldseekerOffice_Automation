Feature: FS Office verify GatewaySync contains and table headers
   To Verify Trap Location in GatewaySync contains all the expected table headers

  @FSOS3
  Scenario: User verify Trap Location table headers in GatewaySync contains
    Given User is on loginpage and navigates to SignIn Page
    When User is navigates to GatewaySync and select Trap Location
    Then verify that Trap location table headers
