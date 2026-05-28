@automation
Feature: Flujo de compra en SauceDemo
  Como usuario registrado
  Quiero realizar una compra completa
  Para verificar que el flujo de checkout funciona correctamente

  Scenario Outline: Compra exitosa con usuario valido
    Given que el usuario se encuentra en la pagina de SauceDemo
    When inicia sesion con credenciales validas
    And compra <cantidad> productos
    Then debe ver el mensaje de confirmacion "<mensaje>"

    Examples:
      | cantidad | mensaje                   |
      | 2        | Thank you for your order! |
