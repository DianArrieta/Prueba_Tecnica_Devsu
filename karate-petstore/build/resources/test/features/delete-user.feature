@ignore
Feature: Eliminar usuario

  Background:
    * url baseUrl

  Scenario:
    Given path 'user', username
    When method delete
    Then status 200