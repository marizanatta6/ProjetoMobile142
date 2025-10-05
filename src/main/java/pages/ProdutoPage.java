package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProdutoPage {

    private WebDriver driver;

    private By origem = By.name("fromPort");
    private By destino = By.name("toPort");
    private By botaoPesquisar = By.cssSelector("input[type='submit']");

    public ProdutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selecionarOrigem(String cidade) {
        new Select(driver.findElement(origem)).selectByVisibleText(cidade);
    }

    public void selecionarDestino(String cidade) {
        new Select(driver.findElement(destino)).selectByVisibleText(cidade);
    }

    public void clicarPesquisar() {
        driver.findElement(botaoPesquisar).click();
    }
}
