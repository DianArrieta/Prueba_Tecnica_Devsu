package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OverviewPage {

    public static final Target FINISH_BUTTON = Target.the("boton finalizar compra")
            .locatedBy("#finish");

    private OverviewPage() {
    }
}
