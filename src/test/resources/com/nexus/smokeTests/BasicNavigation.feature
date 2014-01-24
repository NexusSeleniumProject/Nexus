Feature: Test1

  Scenario: BasicNavigation
    Given Start An Application
    And  Login in application
    And Verify Consolidated View
    And Open Latest News
    And Verify Basic Attributes On Detailed View
    And Click At First Article Header Product Section
    And Verify PDF Viewer Is Open
    And Click At First Article Header Research Section
    And Verify PDF Viewer Is Open
    And Open Nexus Main Page
    And Click At the First Most Popular Article
    And Verify Basic Attributes On Detailed View
    And Open Nexus Main Page
    And Click At the First Latest Bookmart Article
    And Verify Basic Attributes On Detailed View
    And Open Nexus Main Page
    When Click At the First Latest Bookmart Article
    Then Open Nexus Main Page
