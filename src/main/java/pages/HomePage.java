package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;

    private By origem = By.name("fromPort");
    private By destino = By.name("toPort");
    private By botaoPesquisar = By.cssSelector("input[type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selecionarOrigem(String cidade) {
        Select selectOrigem = new Select(driver.findElement(origem));
        selectOrigem.selectByVisibleText(cidade);
    }

    public void selecionarDestino(String cidade) {
        Select selectDestino = new Select(driver.findElement(destino));
        selectDestino.selectByVisibleText(cidade);
    }

    public void clicarPesquisar() {
        driver.findElement(botaoPesquisar).click();
    }
}
