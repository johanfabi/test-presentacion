package pageobjects;

import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.JavascriptExecutor;

public class ExamplePage {

    /* Driver Definition */
    private static RemoteWebDriver driver;

    /**
     ***************************************************************************************************
     * Get environments variables
     ***************************************************************************************************
     */

    // public static String user = System.getenv().get("USER");
    // public static String pass = System.getenv().get("PASS");
    public static String tags = System.getenv().get("TAGS");

    /**
     ***************************************************************************************************
     * Browser Configuration
     ***************************************************************************************************
     */

    /* Open Local Driver */
    public static void openLocal(String url, String title){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,title);
    }

    /* Open with Selenoid */
    public static void openWithSelenoid(String url, String title) throws MalformedURLException {
        String URL = "http://192.168.1.75:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        HashMap<String, Object> selenoidOptions = new HashMap<String, Object>();
        selenoidOptions.put("browserVersion", "110.0");
        selenoidOptions.put("name", "Case: " + tags + " - Example Functional Testing");
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("videoName", "Case: " + tags + " - Example Functional Testing.mp4");
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableLog", true);
        capabilities.setCapability("selenoid:options", selenoidOptions);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.manage().window().maximize();
        driver.get(url);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,title);
    }

    /* Open with BrowserStack */
    public static void openWithBrowserStack(String url, String title) throws MalformedURLException {
        String AUTOMATE_USERNAME = "devopsfunctional_q39rj7";
        String AUTOMATE_ACCESS_KEY = "xktqbPXghHMxfREuCyWZ";
        String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("browserVersion", "110.0");
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "11");
        browserstackOptions.put("projectName", "BeDevOps");
        browserstackOptions.put("buildName", "Case: " + tags + " - Example Functional Testing");
        browserstackOptions.put("sessionName", tags);
        browserstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.manage().window().maximize();
        driver.get(url);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,title);
    }

    /* Quit Driver */
    public static void quitDriver() {
        driver.quit();
    }

    /**
     ***************************************************************************************************
     * Test Case @Test1 - Methods, functions, procedures, actions
     ***************************************************************************************************
     */

    /* Login */
    public static void login() {
        WebElement inputUser = driver.findElement(By.id("username"));
        inputUser.clear();
        inputUser.sendKeys("tomsmith");

        WebElement inputPass = driver.findElement(By.id("password"));
        inputPass.clear();
        inputPass.sendKeys("SuperSecretPassword!");

        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        btnLogin.click();
    }

    /* Validate login */
    public static void validateLogin() {
        WebElement secureArea = driver.findElement(By.xpath("//div[@id='content']/div/h4"));
        String welcomeMessage = secureArea.getText();
        System.out.println("Secure Area Message: " + welcomeMessage);
        String message = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(welcomeMessage,message);
    }

    /**
     ***************************************************************************************************
     * Test Case @Test2 - Methods, functions, procedures, actions
     ***************************************************************************************************
     */

    /* Enter search */
    public static void writeSearch(String search) {
        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.clear();
        System.out.println("Google Search:" + search);
        inputSearch.sendKeys(search);
        inputSearch.sendKeys(Keys.ENTER);
    }

    /* Validate page title */
    public static void validatePageTitle(String title) {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,title + " - Buscar con Google");
    }
}
