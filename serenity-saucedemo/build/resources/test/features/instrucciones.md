Realice una prueba funcional automatizada (PRUEBA E2E) de un flujo de compra en la pagina https://www.saucedemo.com que incluya:
1. Autenticarse con el usuarrio standard_user  y contraseña secret_sauce 
2. Agregar dos productos al carrito
3. visualizar el carrito
4. completar el formulariod e compra
5. finalizar la compra hasta la confirmacion Thank you for your order!


Para los selectores, tienes los htmo en la carpeta features, en el orden de cada paso del proceso de compra, desde el login hasta el mensaje de comrpa exitoso. Extraelos de aqui.

Para la solucion crea un escenario outline desde el cual se envia el mesnaje esperado: Thank you for your order!
usa el archivo de serenity.conf para enviar las credenciales del login y la url de la pagina con esta estructura


environments {
default {
webdriver.base.url = "https://demo.com"

    credentials {
      username = "user_demo"
      password = "12345"
    }
}
}

Para obetner las credenciales para la task de login, una unsa clase utilitaria que obtenga dichas credenciales


Crea tambien un archivo readme.txt con las instrucciones para ejecutar la prueba y generar el reporte de Serenity.
y un archivo de conclusiones.txt con los hallazgos y conclusiones de la prueba realizada.