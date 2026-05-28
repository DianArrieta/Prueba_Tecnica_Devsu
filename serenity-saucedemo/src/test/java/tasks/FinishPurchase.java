package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.OverviewPage;

public class FinishPurchase implements Task {

    public static FinishPurchase fromOverview() {
        return Tasks.instrumented(FinishPurchase.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OverviewPage.FINISH_BUTTON));
    }
}



