@ignore
Feature: Create user

  Background:
    * url baseUrl

  Scenario:
    * def createUserBody = read('classpath:data/create-user.json')
    * def randomEmail = 'user_' + java.util.UUID.randomUUID() + '@mail.com'
    * def randomName = 'User_' + java.util.UUID.randomUUID()
    * set createUserBody.email = randomEmail
    * set createUserBody.username = randomName

    Given path '/user'
    And request createUserBody
    And header Content-Type = 'application/json'
    When method POST
    Then status 200
    And match response.code == 200
    * def username = randomName
    * def email = randomEmail
