package tasks;

import interactions.EnterCredentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.LoginPage;
import utils.EnvironmentConfig;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withEnvironmentCredentials() {
        return instrumented(Login.class,
                EnvironmentConfig.getUsername(),
                EnvironmentConfig.getPassword());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterCredentials.with(username, password),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
