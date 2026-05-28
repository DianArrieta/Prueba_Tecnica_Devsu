package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.OrderConfirmation;
import tasks.AddProductsToCart;
import tasks.FillCheckoutForm;
import tasks.FinishPurchase;
import tasks.Login;
import tasks.ViewCart;
import utils.EnvironmentConfig;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class PurchaseStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el {word} se encuentra en la pagina de SauceDemo")
    public void actorSeEncuentraEnLaPaginaDeSauceDemo(String actorName) {
        var actor = OnStage.theActorCalled(actorName);
        actor.wasAbleTo(Open.url(EnvironmentConfig.getBaseUrl()));
    }

    @When("inicia sesion con credenciales validas")
    public void actorIniciaSesionConCredencialesValidas() {
        theActorInTheSpotlight().attemptsTo(Login.withEnvironmentCredentials());
    }

    @And("compra {int} productos")
    public void actorRealizaProcesoDeCompra(int cantidad) {
        theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.withCount(cantidad),
                ViewCart.fromInventory(),
                FillCheckoutForm.with("firstName", "lastName", "postalCode"),
                FinishPurchase.fromOverview()
        );
    }

    @Then("debe ver el mensaje de confirmacion {string}")
    public void actorDeberiaVerElMensajeDeConfirmacion(String expectedMessage) {
        theActorInTheSpotlight().should(
            seeThat(
                OrderConfirmation.displayed(),
                containsString(expectedMessage)
            )
        );
    }

}
