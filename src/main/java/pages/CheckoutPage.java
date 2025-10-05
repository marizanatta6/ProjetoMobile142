package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By inputName = By.id("inputName");
    private By inputAddress = By.id("address");
    private By inputCity = By.id("city");
    private By inputState = By.id("state");
    private By inputZipCode = By.id("zipCode");
    private By inputCardType = By.id("cardType");
    private By inputCreditCardNumber = By.id("creditCardNumber");
    private By inputCreditCardMonth = By.id("creditCardMonth");
    private By inputCreditCardYear = By.id("creditCardYear");
    private By inputNameOnCard = By.id("nameOnCard");
    private By botaoPurchaseFlight = By.cssSelector("input[type='submit']");

    private By numeroVoo = By.xpath("//table[@class='table']/tbody/tr[1]/td[2]");
    private By precoVoo = By.xpath("//table[@class='table']/tbody/tr[2]/td[2]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void preencherDadosCheckout(String name, String address, String city, String state,
                                       String zipCode, String cardType, String cardNumber,
                                       String month, String year, String nameOnCard) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputCity).sendKeys(city);
        driver.findElement(inputState).sendKeys(state);
        driver.findElement(inputZipCode).sendKeys(zipCode);
        driver.findElement(inputCardType).sendKeys(cardType);
        driver.findElement(inputCreditCardNumber).sendKeys(cardNumber);
        driver.findElement(inputCreditCardMonth).clear();
        driver.findElement(inputCreditCardMonth).sendKeys(month);
        driver.findElement(inputCreditCardYear).clear();
        driver.findElement(inputCreditCardYear).sendKeys(year);
        driver.findElement(inputNameOnCard).sendKeys(nameOnCard);
    }

    public void finalizarCompra() {
        driver.findElement(botaoPurchaseFlight).click();
    }

    public String obterNumeroVooNaCompra() {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(numeroVoo));
        return elemento.getText().trim();
    }

    public String obterPrecoVooNaCompra() {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(precoVoo));
        return elemento.getText().trim();
    }
}
