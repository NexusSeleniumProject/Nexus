@run
Feature: Test1

  Scenario Scenario Outline: BasicNavigation
    Given  Start An Application
    And Login in application
    When  Verify Consolidated View
    Then Open Nexus Main Page