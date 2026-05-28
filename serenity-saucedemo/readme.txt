=====================================================================
 INSTRUCCIONES DE EJECUCION - PRUEBA E2E SAUCEDEMO
 Serenity BDD + Screenplay + Cucumber + Gradle
=====================================================================

RESUMEN
-------
Este proyecto automatiza un flujo E2E de compra en https://www.saucedemo.com
con Serenity BDD (Screenplay) + Cucumber + Gradle.

Cobertura actual del escenario principal:
1) Abrir la pagina de SauceDemo
2) Iniciar sesion con credenciales de configuracion
3) Agregar N productos del inventario (parametrizado)
4) Ir al carrito
5) Completar checkout
6) Finalizar compra
7) Validar mensaje de confirmacion

Escenario activo:
- Archivo: src/test/resources/features/purchase.feature
- Tipo: Scenario Outline
- Parametros: cantidad, mensaje


REQUISITOS
----------
- Java 17+
- Google Chrome instalado
- Conexion a internet
- No se requiere instalacion local de Gradle (usa wrapper)


CONFIGURACION
-------------
Archivo usado por la automatizacion:
- src/test/resources/serenity.conf

Valores actuales relevantes:
- webdriver.driver = "chrome"
- headless = true
- webdriver.base.url = "https://www.saucedemo.com"
- credentials.username = "standard_user"
- credentials.password = "secret_sauce"

Lectura de datos de entorno:
- Clase: src/test/java/utils/EnvironmentConfig.java
- Metodo: ConfigFactory.parseResources("serenity.conf")


ESTRUCTURA DEL PROYECTO
-----------------------
src/test/java/
  runners/         -> CucumberTestSuite.java
  stepdefinitions/ -> PurchaseStepDefinitions.java
  tasks/           -> Login, AddProductsToCart, ViewCart, FillCheckoutForm, FinishPurchase
  interactions/    -> EnterCredentials
  questions/       -> OrderConfirmation
  userinterfaces/  -> LoginPage, InventoryPage, CartPage, CheckoutPage, OverviewPage, CompletePage
  utils/           -> EnvironmentConfig

src/test/resources/
  serenity.conf
  features/
    purchase.feature


COMO EJECUTAR
-------------
Windows (PowerShell):

  cd C:\Users\DianaArrieta\Documents\Devsu\PRUEBA\E2E
  .\gradlew clean test

Linux/macOS:

  cd /ruta/al/proyecto
  ./gradlew clean test

Nota:
- En este proyecto, test finaliza con aggregate automaticamente
  (build.gradle tiene: test.finalizedBy aggregate).


REPORTE SERENITY
----------------
Ruta del reporte HTML:
- target/site/serenity/index.html

Comando alterno explicito para agregar reportes:
- .\gradlew clean test aggregate


NOTAS TECNICAS IMPORTANTES
--------------------------
- AddProductsToCart agrega productos por posicion (primeros N del inventario).
- Si la cantidad solicitada supera productos disponibles, la tarea lanza error.
- La validacion final se realiza con OrderConfirmation sobre CompletePage.CONFIRMATION_HEADER.
- El runner principal es runners.CucumberTestSuite (tags: not @ignore).


SOLUCION RAPIDA DE PROBLEMAS
----------------------------
1) No abre navegador esperado
   - Revisar webdriver.driver en src/test/resources/serenity.conf

2) Falla por timeout de elemento
   - Revisar selectores en userinterfaces/
   - Ajustar wait.for.timeout y element.timeout en serenity.conf

3) No aparece reporte HTML
   - Ejecutar .\gradlew clean test (incluye aggregate por finalizedBy)
   - Verificar target/site/serenity/index.html

4) Error de configuracion environments/credentials
   - Verificar que serenity.conf este en src/test/resources
   - Verificar claves en environments.default.credentials

=====================================================================
