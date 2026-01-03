package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.web.produnet.LoginUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RevisarRespuesta implements Task   {


    private final String tipo;

    private RevisarRespuesta(String tipo) {

        this.tipo = tipo;
    }




    public static RevisarRespuesta token() {
        return new RevisarRespuesta("token");
    }
    public static RevisarRespuesta contraseniaIncorrecta() {
        return new RevisarRespuesta("contraseniaIncorrecta");
    }
    public static RevisarRespuesta contraseniaCorrecta() {
        return new RevisarRespuesta("contraseniaCorrecta");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo) {
            case "token":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.LBL_INGRESAR_CODIGO, isVisible())
                );
                actor.should(
                        seeThat(Text.of(LoginUI.LBL_INGRESAR_CODIGO), containsString("temporal enviado al correo")),
                        seeThat(Attribute.of(LoginUI.BTN_ACEPTAR_TOKEN).named("disabled"), equalTo("true"))
                );
                break;
            case "contraseniaIncorrecta":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.MODAL_ERROR_USUARIO, isVisible())
                );
                actor.should(
                        seeThat(Text.of(LoginUI.MODAL_ERROR_USUARIO), containsString("Error al obtener el usuario"))
                );
                break;
            case "contraseniaCorrecta":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.MODAL_ERROR_PASSWORD, isVisible())
                );
                actor.should(
                        seeThat(Text.of(LoginUI.MODAL_ERROR_PASSWORD), containsString("La información ingresada"))
                );
                break;
        }
    }

}
