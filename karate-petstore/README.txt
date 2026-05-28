================================================================================
        PROYECTO KARATE + GRADLE - PETSTORE API
================================================================================

DESCRIPCIÓN DEL PROYECTO
----------------------------
Este proyecto automatiza un flujo end-to-end de usuario contra la API pública
Petstore utilizando Karate Framework, Gradle y JUnit 5.

API bajo prueba:
  https://petstore.swagger.io/v2

El flujo real del proyecto está definido en `src/test/resources/features/user-e2e.feature`
y se compone de un solo Scenario que encadena estas acciones:

  1. Crear usuario
  2. Consultar usuario creado
  3. Actualizar nombre y correo
  4. Consultar usuario actualizado
  5. Eliminar usuario

Los pasos 1, 2, 3 y 5 se delegan a features auxiliares marcados con `@ignore`:
`create-user.feature`, `get-user.feature`, `update-user.feature` y `delete-user.feature`.


ESTRUCTURA PRINCIPAL DEL PROYECTO
------------------------------------
karate-petstore/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── init-wrapper.bat
├── init-wrapper.sh
├── gradle/wrapper/gradle-wrapper.properties
├── README.txt
├── conclusiones.txt
└── src/test/
    ├── java/runners/TestRunner.java
    └── resources/
        ├── karate-config.js
        ├── data/
        │   ├── create-user.json
        │   └── update-user.json
        └── features/
            ├── user-e2e.feature
            ├── create-user.feature
            ├── get-user.feature
            ├── update-user.feature
            └── delete-user.feature


REQUISITOS
-------------
✓ Java JDK 11 o superior
✓ Acceso a Internet para llegar a la API Petstore

La configuración del proyecto declara Gradle Wrapper 7.6 y Karate 1.4.0.


CÓMO EJECUTAR LOS TESTS
--------------------------

Opción recomendada si el wrapper está disponible:

Windows con limpieza previa:
    .\gradlew clean test

Si el wrapper no está inicializado en esta copia del proyecto, usa Gradle local:

    gradle test

Desde un IDE:
1. Abrir el proyecto en IntelliJ IDEA o VS Code.
2. Ejecutar `src/test/java/runners/TestRunner.java`.


REPORTES DE EJECUCIÓN
------------------------
Después de correr la suite, los reportes quedan en:

  Karate:  build/karate-reports/karate-summary.html
  JUnit:   build/reports/tests/test/index.html

También se genera el resumen JSON de Karate en:

  build/karate-reports/karate-summary-json.txt

En la ejecución validada del proyecto el resultado fue:

  1 feature ejecutado
  1 scenario pasado
  4 features auxiliares omitidos por `@ignore`
  0 fallos


🔧 ARCHIVOS CLAVE
-----------------

build.gradle
  - Declara el plugin de Java
  - Usa `com.intuit.karate:karate-junit5:1.4.0`
  - Fuerza Java 11 como compatibilidad

TestRunner.java
  - Ejecuta `Runner.path("classpath:features").parallel(1)`
  - Mantiene el flujo en una sola hebra para respetar el orden del E2E

karate-config.js
  - Centraliza `baseUrl = https://petstore.swagger.io/v2`

user-e2e.feature
  - Orquesta el flujo completo de usuario
  - Captura `username` y `email` devueltos por los helpers

create-user.feature / update-user.feature
  - Generan `username` y `email` aleatorios por ejecución
  - Reutilizan los JSON base de `src/test/resources/data/`

get-user.feature / delete-user.feature
  - Consumidores simples del `username` actual del escenario


DATOS Y COMPORTAMIENTO
-------------------------
`create-user.json` y `update-user.json` contienen la base del request.
Durante la ejecución, Karate sobreescribe los campos dinámicos necesarios.



NOTAS IMPORTANTES
-------------------
• Los features auxiliares llevan `@ignore` para no ejecutarse como tests
  independientes.
• Si el wrapper no está disponible, usa `gradle test` con una instalación
  local de Gradle o regenera el wrapper del proyecto.
• Si la API no responde, verifica la conectividad a Internet y la disponibilidad
  del endpoint público.

