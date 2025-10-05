package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CarrinhoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By tabelaVoos = By.cssSelector("table.table tbody tr");

    private By nomeVooCompra = By.xpath("//p/em[contains(text(),'Flight Number')]");
    private By precoVooCompra = By.xpath("//p/em[contains(text(),'Price:')]");

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public String obterNomePrimeiroVoo() {
        List<WebElement> linhas = driver.findElements(tabelaVoos);
        WebElement primeiraLinha = linhas.get(0);
        return primeiraLinha.findElement(By.xpath("td[2]")).getText();
    }

    public String obterPrecoPrimeiroVoo() {
        List<WebElement> linhas = driver.findElements(tabelaVoos);
        WebElement primeiraLinha = linhas.get(0);
        return primeiraLinha.findElement(By.xpath("td[6]")).getText();
    }

    public void escolherPrimeiroVoo() {
        List<WebElement> linhas = driver.findElements(tabelaVoos);
        WebElement primeiraLinha = linhas.get(0);
        primeiraLinha.findElement(By.xpath("td[1]/input")).click();
    }

    public String obterNomeVooNaCompra() {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(nomeVooCompra));
        String texto = elemento.getText();
        return texto.replace("Flight Number:", "").trim();
    }

    public String obterPrecoVooNaCompra() {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(precoVooCompra));
        String texto = elemento.getText();
        return texto.replace("Price:", "").trim();
    }
}
