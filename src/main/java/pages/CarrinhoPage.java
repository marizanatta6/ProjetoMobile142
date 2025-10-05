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

    private By tabelaVoos = By.xpath("//table[@class='table']/tbody/tr");

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String obterNomePrimeiroVoo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabelaVoos));

        List<WebElement> linhas = driver.findElements(tabelaVoos);
        if (linhas.isEmpty()) {
            throw new RuntimeException("Nenhum voo disponível para seleção.");
        }

        WebElement primeiraLinha = linhas.get(0);
        return primeiraLinha.findElement(By.xpath("td[3]")).getText().trim();
    }

    public String obterPrecoPrimeiroVoo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabelaVoos));

        List<WebElement> linhas = driver.findElements(tabelaVoos);
        if (linhas.isEmpty()) {
            throw new RuntimeException("Nenhum voo disponível para seleção.");
        }

        WebElement primeiraLinha = linhas.get(0);
        return primeiraLinha.findElement(By.xpath("td[6]")).getText().trim();
    }

    public void selecionarPrimeiroVoo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabelaVoos));

        List<WebElement> linhas = driver.findElements(tabelaVoos);
        if (linhas.isEmpty()) {
            throw new RuntimeException("Nenhum voo disponível para seleção.");
        }

        WebElement primeiraLinha = linhas.get(0);
        primeiraLinha.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
