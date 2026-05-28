package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.CartPage;
import userinterfaces.InventoryPage;

public class AddProductsToCart implements Task {

    private final int cantidad;

    public AddProductsToCart(int cantidad) {
        this.cantidad = cantidad;
    }

    public static AddProductsToCart withCount(int cantidad) {
        return Tasks.instrumented(AddProductsToCart.class, cantidad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad de productos debe ser mayor o igual a 1");
        }

        int availableProducts = InventoryPage.ADD_TO_CART_BUTTONS.resolveAllFor(actor).size();
        if (cantidad > availableProducts) {
            throw new IllegalArgumentException(
                    "No hay suficientes productos en el inventario. Solicitados: " + cantidad
                            + ", disponibles: " + availableProducts
            );
        }

        for (int index = 1; index <= cantidad; index++) {
            actor.attemptsTo(Click.on(InventoryPage.addButtonForProduct(index)));
        }
        actor.attemptsTo(
                Ensure.that(Text.of(CartPage.CART_ITEMS))
                        .contains(String.valueOf(cantidad))
        );

    }
}







