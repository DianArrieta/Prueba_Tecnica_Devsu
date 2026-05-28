@ignore
Feature: Get user

  Background:
    * url baseUrl

  Scenario:
    Given path 'user', username
    When method get
    Then status 200
