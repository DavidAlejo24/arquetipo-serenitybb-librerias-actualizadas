package starter.stepdefinitions.web.produnet;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.NavegarHacia;
import tasks.web.produnet.IngresarCredenciales;
import tasks.web.produnet.RevisarRespuesta;

import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.Before;


public class LoginStepDefinitions {

    @Before
    public void setTheStage() {OnStage.setTheStage(new OnlineCast());}



    @Dado("que el {actor} abre la Produnet web")
    public void clienteAbreProdunetWeb(Actor cliente) {
        cliente.wasAbleTo(NavegarHacia.produnetLogin());
    }


    @Cuando("ingresa su usuario y contrasenia correctas")
    public void ingresa_su_usuario_y_contrasena_correctas() {
        when(theActorInTheSpotlight()).attemptsTo(
                IngresarCredenciales.userCorrecto()
                //IngresarCredenciales.pwdCorrecta()
        );
    }

    @Entonces("valida que se vea la pantalla de token")
    public void clienteValidaPantallaToken() {
        // Implement validation logic for the token screen
        theActorInTheSpotlight().wasAbleTo(
                RevisarRespuesta.token()
                //RevisaRespuesta.usuarioIncorrecto()
                //RevisaRespuesta.contraseniaIncorrecta()
        );
    }

    @Cuando("ingresa su usuario incorrecto")
    public void clienteIngresaUsuarioIncorrecto() {
        theActorInTheSpotlight().wasAbleTo(
                IngresarCredenciales.userIncorrecto()
        );
    }

    @Entonces("valida se muestre un mensaje de error de usuario")
    public void clienteValidaErrorUsuario() {
        // Implement validation logic for incorrect username error
        System.out.println("Validating incorrect username error...");
    }

    @Cuando("ingresa su contraseña incorrecta")
    public void clienteIngresaContrasenaIncorrecta() {
        theActorInTheSpotlight().wasAbleTo(
                IngresarCredenciales.userCorrecto(),
                IngresarCredenciales.pwdIncorrecta()
        );
    }

    @Entonces("valida se muestre un mensaje de error de contraseña")
    public void clienteValidaErrorContrasena() {
        // Implement validation logic for incorrect password error
        System.out.println("Validating incorrect password error...");
    }

}
