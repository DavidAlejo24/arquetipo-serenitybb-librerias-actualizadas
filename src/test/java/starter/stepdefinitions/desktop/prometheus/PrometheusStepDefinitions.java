package starter.stepdefinitions.desktop.prometheus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import tasks.desktop.prometheus.AbrirBrowser;

public class PrometheusStepDefinitions {

    @Given("{actor} open the browser")
    public void abreChrome(Actor actor) {
        actor.attemptsTo(
                AbrirBrowser.Chrome()
        );
    }

    /*
    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }
*/
    @Then("valida que el browser este abierto en la pagina deseada")
    public void validaBrowserEsteAbiertoEnPaginaDeseada(){

    }

}
