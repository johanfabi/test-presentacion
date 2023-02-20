package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.UIManager.put;

public class ExamplePage {

    /* Definir WebDriver */
    private static RemoteWebDriver driver;

    /**
     ***************************************************************************************************
     * Elementos globales del sitio web
     ***************************************************************************************************
     */

    /* Input de búsqueda */
    // @FindBy(name = "q")
    // public static WebElement inputSearch;

    /**
     ***************************************************************************************************
     * Métodos, funciones y procedimientos para interactuar con los elementos de la página
     ***************************************************************************************************
     */

    /* Abrir el sitio web en local */
    public static void abrirLocal(String url){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    /* Abrir el sitio web en Selenoid */
    public static void abrirSelenoid(String url) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "109.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        driver = new RemoteWebDriver(new URL("http://34.67.214.112:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void openSelenoid(String url) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "109.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");
            /* How to set session timeout */
            put("sessionTimeout", "15m");
            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            /* How to enable video recording */
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://34.67.214.112:4444/wd/hub"), options);
    }

    /* Ingresar texto en el input de búsqueda */
    public static void escribirBusqueda(String busqueda) {
        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.clear();
        System.out.println("Buscar en Google:" + busqueda);
        inputSearch.sendKeys(busqueda);
        inputSearch.sendKeys(Keys.ENTER);
    }

    /* Validar el título de la página */
    public static void validarTitulo(String titulo) {
        String title = driver.getTitle();
        Assert.assertEquals(title,titulo + " - Buscar con Google");
        driver.close();
    }
}
