package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ExamplePage;
import java.net.MalformedURLException;

public class ExamplesSteps {

    /**
     ***************************************************************************************************
     * Test Case @Test1
     ***************************************************************************************************
     */

    @Given("Cargo el sitio web HerokuApp")
    public void cargoElSitioWebHerokuApp() throws MalformedURLException {
        ExamplePage.openLocal("https://the-internet.herokuapp.com/login", "The Internet");
    }

    @When("Escribo el usuario y password")
    public void escriboElUsuarioYPassword() {
        ExamplePage.login();
    }

    @Then("Valido login exitoso")
    public void validoLoginExitoso() {
        ExamplePage.validateLogin();
        ExamplePage.quitDriver();
    }

    /**
     ***************************************************************************************************
     * Test Case @Test2
     ***************************************************************************************************
     */

    @Given("Cargo el sitio web Google")
    public void cargoElSitioWebGoogle() {
        ExamplePage.openLocal("https://www.google.com/", "Google");
    }

    @When("Escribo en el input de busqueda")
    public void escriboEnElInputDeBusqueda() throws InterruptedException {
        ExamplePage.writeSearch("Autos");
        Thread.sleep(1000);
    }

    @Then("Valido el resultado de la busqueda")
    public void validoElResultadoDeLaBusqueda() {
        ExamplePage.validatePageTitle("Autos");
        ExamplePage.quitDriver();
    }
}
