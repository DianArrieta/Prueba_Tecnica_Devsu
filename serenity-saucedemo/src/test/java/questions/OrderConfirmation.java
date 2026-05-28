package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.CompletePage.CONFIRMATION_HEADER;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation displayed() {
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {


        actor.attemptsTo(
                WaitUntil.the(CONFIRMATION_HEADER, isVisible())
                        .forNoMoreThan(30).seconds()
        );

        actor.attemptsTo(
                Ensure.that(Text.of(CONFIRMATION_HEADER))
                        .contains("Thank you for your order!")
        );


        return Text.of(CONFIRMATION_HEADER).answeredBy(actor);
    }
}

