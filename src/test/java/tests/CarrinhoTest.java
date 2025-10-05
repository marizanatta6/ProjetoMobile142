package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class CarrinhoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
            driver.quit();
    }

    @Test
    public void searchAndAddProductToCart() {
        driver.get("https://blazedemo.com/");

        WebElement fromPort = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromPort")));
        fromPort.sendKeys("São Paolo"); 

        WebElement toPort = driver.findElement(By.name("toPort"));
        toPort.sendKeys("New York"); 

        WebElement findFlightsButton = driver.findElement(By.cssSelector("input[type='submit']"));
        findFlightsButton.click();

        WebElement chooseFlightButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Choose This Flight']")));
        chooseFlightButton.click();

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputName")));
        nameField.sendKeys("Teste Usuario");

        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys("Rua Ficticia, 123");

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Cidade Exemplo");

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("XX");

        WebElement zipCodeField = driver.findElement(By.id("zipCode"));
        zipCodeField.sendKeys("00000000");

        WebElement cardTypeField = driver.findElement(By.id("cardType"));
        cardTypeField.sendKeys("Visa");

        WebElement creditCardNumberField = driver.findElement(By.id("creditCardNumber"));
        creditCardNumberField.sendKeys("4111111111111111");

        WebElement creditCardMonthField = driver.findElement(By.id("creditCardMonth"));
        creditCardMonthField.clear();
        creditCardMonthField.sendKeys("12");

        WebElement creditCardYearField = driver.findElement(By.id("creditCardYear"));
        creditCardYearField.clear();
        creditCardYearField.sendKeys("30");

        WebElement nameOnCardField = driver.findElement(By.id("nameOnCard"));
        nameOnCardField.sendKeys("Teste Usuario");

        WebElement purchaseFlightButton = driver.findElement(By.cssSelector("input[type='submit']"));
        purchaseFlightButton.click();
    }

    
}
