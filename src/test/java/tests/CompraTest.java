package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CompraTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testeCompraVoo() {
        driver.get("https://blazedemo.com"); 

        driver.findElement(By.name("fromPort")).sendKeys("Boston");
        driver.findElement(By.name("toPort")).sendKeys("London");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table tbody tr")));
        driver.findElement(By.cssSelector("table.table tbody tr:first-child td input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("inputName"))).sendKeys("Teste");
        driver.findElement(By.name("address")).sendKeys("Rua Teste, 123");
        driver.findElement(By.name("city")).sendKeys("Testelândia");
        driver.findElement(By.name("state")).sendKeys("GO");
        driver.findElement(By.name("zipCode")).sendKeys("00000-000");
        driver.findElement(By.name("creditCardNumber")).sendKeys("8111111111111111");
        driver.findElement(By.name("creditCardMonth")).clear();
        driver.findElement(By.name("creditCardMonth")).sendKeys("12");
        driver.findElement(By.name("creditCardYear")).clear();
        driver.findElement(By.name("creditCardYear")).sendKeys("2025");
        driver.findElement(By.name("nameOnCard")).sendKeys(" Teste");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement mensagemConfirmacao = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Thank you')]")
            )
        );

        assertTrue(mensagemConfirmacao.isDisplayed(), "Mensagem de confirmação não apareceu!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
