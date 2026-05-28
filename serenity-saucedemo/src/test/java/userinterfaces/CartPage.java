package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target CHECKOUT_BUTTON = Target.the("boton checkout del carrito")
            .locatedBy("[data-test='checkout']");

    public static final Target CART_ITEMS = Target.the("items del carrito")
            .locatedBy("[data-test='shopping-cart-badge']");

    private CartPage() {
    }
}