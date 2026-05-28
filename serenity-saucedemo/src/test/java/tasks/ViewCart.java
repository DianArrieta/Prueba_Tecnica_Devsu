package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.InventoryPage;

public class ViewCart implements Task {

    public static ViewCart fromInventory() {
        return Tasks.instrumented(ViewCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.SHOPPING_CART)
        );
    }
}



