package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By searchBox = By.id("search_input");
    private By searchButton = By.id("search_button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void pesquisaProduto(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void selecionaProduto(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']")).click();
    }
}
