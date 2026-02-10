package tasks.appium;

import actions.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class OpenApp implements Task {

    private HomePage homePage;

    public static OpenApp now() {
        return Tasks.instrumented(OpenApp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Aquí simplemente validamos que la app abrió
        homePage.open();
    }
}
