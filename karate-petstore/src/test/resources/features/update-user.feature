@ignore
Feature: AUpdate User

  Background:
    * url baseUrl

  Scenario:
    * def updateUserBody = read('classpath:data/update-user.json')
    * def randomEmail = 'user_' + java.util.UUID.randomUUID() + '@mail.com'
    * def randomName = 'User_' + java.util.UUID.randomUUID()
    * set updateUserBody.email = randomEmail
    * set updateUserBody.username = randomName

    Given path 'user', username
    And request updateUserBody
    When method put
    Then status 200
    * def email = randomEmail
    * def username = randomName