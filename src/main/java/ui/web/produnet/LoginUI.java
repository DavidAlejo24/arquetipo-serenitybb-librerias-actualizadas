package ui.web.produnet;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;


public class LoginUI extends PageObject {

    //Pagina username
    public static final Target LBL_BIENVENIDA = Target.the("Label de bienvenida").located(By.xpath("//h4[normalize-space(text())='Hola, te damos la bienvenida']")).waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target INPUT_USERNAME = Target.the("Input del Username").locatedBy("//input[@id='NombreUsuario']").waitingForNoMoreThan(Duration.ofSeconds(10));

    //Pagina password
    public static final Target INPUT_PASSWORD = Target.the("Input del Password").locatedBy("//input[@id='input_Clave']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target BTN_CHECK_PASSWORD = Target.the("Boton de Mostrar").locatedBy("//button[@id='btnMostrar']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target BTN_INGRESAR = Target.the("Boton de Mostrar").locatedBy("//button[@id='btnAceptar']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target BTN_CANCELAR = Target.the("Boton de Mostrar").locatedBy("//a[@id='btnAtras']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target TELEFONO_SOPORTE = Target.the("//a[@href='tel:024009000']").locatedBy("//a[@href='tel:024009000']").waitingForNoMoreThan(Duration.ofSeconds(10));


    //Pagina de Token
    public static final Target LBL_INGRESAR_CODIGO = Target.the("Label Ingresa el código temporal").locatedBy("//p[@id='lblCodigoSeguridadTemporal']").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static final Target BTN_ACEPTAR_TOKEN = Target.the("botón aceptar segundo factor")
            .locatedBy("//button[@id='btnAceptarValidarSegundoFactor']");

    public static final Target BTN_CANCELAR_TOKEN = Target.the("botón cancelar segundo factor")
            .locatedBy("//a[@id='btnAtras']");

    public static final Target LNK_SOLICITAR_CODIGO = Target.the("enlace solicitar código temporal")
            .locatedBy("//a[@id='idIngresoAlternativo']");




}