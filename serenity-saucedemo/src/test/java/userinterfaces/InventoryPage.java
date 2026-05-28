package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target ADD_TO_CART_BUTTONS = Target.the("botones agregar del inventario")
            .locatedBy("//button[contains(@class,'btn_inventory')]");

    private static final String ADD_TO_CART_BUTTON_BY_POSITION = "(//button[contains(@class,'btn_inventory')])[{0}]";

    public static Target addButtonForProduct(int position) {
        return Target.the("boton agregar del producto #" + position)
                .locatedBy(ADD_TO_CART_BUTTON_BY_POSITION.replace("{0}", String.valueOf(position)));
    }

    public static final Target SHOPPING_CART = Target.the("icono del carrito")
            .locatedBy("[data-test='shopping-cart-badge']");

    private InventoryPage() {
    }
}





