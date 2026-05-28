Feature: Flujo completo usuario

  Scenario: Crear → Consultar → Editar → Consultar → Eliminar

   # 1. CREAR UN USUARIO
    * def createRes = call read('create-user.feature')
    * def username = createRes.username
    * def email = createRes.email

  # 2. BUSCAR EL USUARIO CREADO
    * call read('get-user.feature')

  # 3. ACTUALIZAR EL NOMBRE Y EL CORREO DEL USUARIO
    * def updateRes = call read('update-user.feature')

  # actualizar variables globales
    * def username = updateRes.username
    * def email = updateRes.email

  # 4. BUSCAR EL USUARIO ACTUALIZADO
    * call read('get-user.feature')

  # 5. ELIMINAR USUARIO
    * call read('delete-user.feature')