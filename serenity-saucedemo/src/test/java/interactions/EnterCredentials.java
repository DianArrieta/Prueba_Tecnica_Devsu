package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.LoginPage;

public class EnterCredentials implements Interaction {

    private final String username;
    private final String password;

    public EnterCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static EnterCredentials with(String username, String password) {
        return Tasks.instrumented(EnterCredentials.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_INPUT),
                Enter.theValue(password).into(LoginPage.PASSWORD_INPUT)
        );
    }
}
