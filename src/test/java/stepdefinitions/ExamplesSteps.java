package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ExamplePage;

import java.net.MalformedURLException;

public class ExamplesSteps {

    /* Extrae la variable de entorno MI_BUSQUEDA */
    // String miBusqueda = System.getenv().get("MI_BUSQUEDA");

    /**
     ***************************************************************************************************
     * Background
     ***************************************************************************************************
     */

    @Given("Iniciar sitio web Google")
    public void iniciarSitioWebGoogle() throws MalformedURLException {
        ExamplePage.openSelenoid("https://www.google.com/");
    }

    /**
     ***************************************************************************************************
     * Caso de Prueba @Test
     ***************************************************************************************************
     */

    @When("Escribo en el input de busqueda")
    public void escriboEnElInputDeBusqueda() throws InterruptedException {
        ExamplePage.escribirBusqueda("Autos");
        Thread.sleep(1000);
    }

    @Then("Mostrar el resultado de la busqueda")
    public void mostrarElResultadoDeLaBusqueda() {
        ExamplePage.validarTitulo("Autos");
    }
}
