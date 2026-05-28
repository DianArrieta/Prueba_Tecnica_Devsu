package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target FIRST_NAME = Target.the("campo nombre")
            .locatedBy("#first-name");

    public static final Target LAST_NAME = Target.the("campo apellido")
            .locatedBy("#last-name");

    public static final Target POSTAL_CODE = Target.the("campo codigo postal")
            .locatedBy("#postal-code");

    public static final Target CONTINUE_BUTTON = Target.the("boton continuar")
            .locatedBy("#continue");

    private CheckoutPage() {
    }
}
