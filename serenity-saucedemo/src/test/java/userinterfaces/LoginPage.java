package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target USERNAME_INPUT = Target.the("campo usuario")
            .locatedBy("#user-name");

    public static final Target PASSWORD_INPUT = Target.the("campo clave")
            .locatedBy("#password");

    public static final Target LOGIN_BUTTON = Target.the("boton iniciar sesion")
            .locatedBy("#login-button");

    public static final Target WELCOME_MESSAGE = Target.the("mensaje de bienvenida")
            .locatedBy(".welcome-message");

    private LoginPage() {
    }
}
