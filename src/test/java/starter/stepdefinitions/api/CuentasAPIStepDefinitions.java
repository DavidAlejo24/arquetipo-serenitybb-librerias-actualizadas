package starter.stepdefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.produnet.CodigoDeRespuesta;
import starter.navigation.NavegarHacia;
import tasks.web.produnet.ConsultarAbilities;
import tasks.web.produnet.IngresarCredenciales;
import tasks.web.produnet.RevisarRespuesta;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class CuentasAPIStepDefinitions {
    Actor cliente;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que hago una consulta a la API de Cuentas de un Cliente")
    public void hagoUnaConsultaApiCuentasCliente() {
        cliente = Actor.named("David").whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
        cliente.attemptsTo(
                ConsultarAbilities.desde("/ability/?limit=20&offset=20")
        );
    }

    @Cuando("obtengo el resultado")
    public void obtengoElResultado() {
        cliente.attemptsTo(
                ConsultarAbilities.desde("/ability/?limit=20&offset=20")
        );
    }


    @Entonces("debe existir por lo menos una cuenta asociada al cliente")
    public void debeExistirPorLoMenosUnaCuentaAsociadaAlCliente() {
            cliente.should(
                    seeThat("El código de respuesta",
                            CodigoDeRespuesta.es(),
                            equalTo(200))
            );
    }




}
