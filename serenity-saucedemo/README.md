# Serenity BDD + Screenplay + Cucumber (Gradle)

Proyecto base de automatizacion E2E con Serenity BDD, patron Screenplay y Cucumber.

## Estructura principal

- `src/test/java/runners`: suite Cucumber para Serenity.
- `src/test/java/stepdefinitions`: definiciones de pasos.
- `src/test/java/tasks`: tareas reutilizables de negocio.
- `src/test/java/interactions`: interacciones de UI atomicas.
- `src/test/java/questions`: validaciones/lecturas del estado de la UI.
- `src/test/java/userinterfaces`: `Target` de elementos de pagina.
- `src/test/resources/features`: escenarios Gherkin.

## Requisitos

- Java 17+
- Google Chrome (el driver se descarga automaticamente por Serenity)
- **No se requiere Gradle instalado**: el proyecto incluye el wrapper `gradlew`.

## Ejecucion

```powershell
# Windows
.\gradlew clean test
```

```bash
# Linux / macOS
./gradlew clean test
```

## Reporte

Despues de ejecutar las pruebas, abre:

- `target/site/serenity/index.html`

Para generar el reporte completo:

```powershell
.\gradlew clean test serenityAggregate
```


