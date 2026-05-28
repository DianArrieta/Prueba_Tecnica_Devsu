package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CompletePage {

    public static final Target CONFIRMATION_HEADER = Target.the("mensaje de confirmacion de compra")
            .locatedBy("[data-test='complete-header']");

    private CompletePage() {
    }
}
