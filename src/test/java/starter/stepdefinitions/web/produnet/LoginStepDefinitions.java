package starter.stepdefinitions.web.produnet;

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




public class LoginStepDefinitions {
    //Actor cliente = Actor.named("David");
    Actor cliente;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        //cliente().whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
        cliente = Actor.named("David").whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));

    }




    @Dado("que el {actor} abre la Produnet web")
    public void clienteAbreProdunetWeb() {
        cliente.wasAbleTo(NavegarHacia.produnetLogin());
    }


    @Cuando("ingresa su usuario y contrasenia correctas")
    public void ingresa_su_usuario_y_contrasena_correctas() {
        when(theActorInTheSpotlight()).attemptsTo(
                IngresarCredenciales.userCorrecto(),
                IngresarCredenciales.pwdCorrecta()
        );
    }

    @Entonces("valida que se vea la pantalla de token")
    public void clienteValidaPantallaToken() {
        // Implement validation logic for the token screen
        theActorInTheSpotlight().wasAbleTo(
                RevisarRespuesta.token()
        );
    }

    @Cuando("ingresa su usuario incorrecto")
    public void clienteIngresaUsuarioIncorrecto() {
        theActorInTheSpotlight().wasAbleTo(
                IngresarCredenciales.userIncorrecto(),
                IngresarCredenciales.pwdCorrecta()
        );
    }

    @Entonces("valida se muestre un mensaje de error de usuario")
    public void clienteValidaErrorUsuario() {
        theActorInTheSpotlight().wasAbleTo(
                RevisarRespuesta.contraseniaIncorrecta()
        );
    }

    @Cuando("ingresa su contrasenia incorrecta")
    public void clienteIngresaContrasenaIncorrecta() {
        theActorInTheSpotlight().wasAbleTo(
                IngresarCredenciales.userCorrecto(),
                IngresarCredenciales.pwdIncorrecta()
        );
    }

    @Entonces("valida que se muestre un mensaje de error de contrasenia")
    public void clienteValidaErrorContrasena() {

        theActorInTheSpotlight().wasAbleTo(
                RevisarRespuesta.contraseniaCorrecta()
        );
    }

    //Exampe restAssured

    @Cuando("consulta las habilidades de pokemon con limite y offset")
    public void consultoAbilities() {
        cliente.attemptsTo(
                ConsultarAbilities.desde("/ability/?limit=20&offset=20")
        );
    }

    @Entonces("el servicio responde exitosamente")
    public void validaCodigoRespuesta() {
        cliente.should(
                seeThat("El código de respuesta",
                        CodigoDeRespuesta.es(),
                        equalTo(200))
        );
    }


}
