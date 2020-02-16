Feature: Concept

  Scenario: Create a new concept when no concept with the same name exist
    Given a concept named Contact
    And no concept exists with the same name
    When the concept is created
    Then a new concept named Contact is appended to the concepts
    And a concept named Contact is created should be returned
