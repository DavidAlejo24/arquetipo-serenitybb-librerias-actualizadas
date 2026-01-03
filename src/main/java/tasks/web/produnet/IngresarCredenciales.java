package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.web.produnet.LoginUI;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.containsString;

public class IngresarCredenciales implements Task   {


    private final String credencial;
    private final String tipo;

    private IngresarCredenciales(String credencial, String tipo) {
        this.credencial = credencial;
        this.tipo = tipo;
    }


    public static IngresarCredenciales username(String credencial) {
        return new IngresarCredenciales(credencial, "username");
    }

    public static IngresarCredenciales password(String credencial) {
        return new IngresarCredenciales(credencial, "password");
    }

    public static IngresarCredenciales userCorrecto() {
        return new IngresarCredenciales("DACRUZCH", "username");
    }
    public static IngresarCredenciales userIncorrecto() {
        return new IngresarCredenciales("DASDASDASDASASSADASD", "username");
    }

    public static IngresarCredenciales pwdCorrecta() {
        return new IngresarCredenciales("Panecillo@123", "password");
    }
    public static IngresarCredenciales pwdIncorrecta() {
        return new IngresarCredenciales("pwdpwdpwd", "password");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo) {
            case "username":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.LBL_BIENVENIDA, isVisible()).forNoMoreThan(10).seconds()
                );
                //actor.should(seeThat(the(LoginUI.LBL_BIENVENIDA.resolveFor(theActorInTheSpotlight()).getText()), containsText("Hola")));
                actor.should(
                        seeThat(Text.of(LoginUI.LBL_BIENVENIDA), containsString("Hola"))
                );
                actor.attemptsTo(
                        Task.where("{0} ingresa Usuario",
                                //Ensure.that(LoginUI.LBL_BIENVENIDA).contains("Hola"),
                                Enter.theValue(credencial)
                                        .into(LoginUI.INPUT_USERNAME),
                                Click.on(LoginUI.BTN_INGRESAR)
                        )
                );
                break;

            case "password":
                //actor.should(seeThat(the(LoginUI.TELEFONO_SOPORTE.resolveFor(theActorInTheSpotlight()).getText()), containsText("tel:")));
                actor.should(
                        seeThat(Text.of(LoginUI.TELEFONO_SOPORTE), containsString("02 400 9000"))
                );
                actor.attemptsTo(
                        Task.where("{0} ingresa Password",
                                Enter.theValue(credencial)
                                        .into(LoginUI.INPUT_PASSWORD),
                                Click.on(LoginUI.BTN_CANCELAR)
                        )
                );
                break;
        }
    }

}
