import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import java.time.Duration;

public class LoginWebTeste{
    private WebDriver driver;
    
    //setup
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.teste.com.br/");
    }

   @Test
    public void fazLogin(){
        System.out.println("Executando o teste...");

        WebElement Usuario = driver.findElement(By.id("login"));
        Usuario.sendKeys("usuario@gmail.com");

        WebElement senha = driver.findElement(By.id("senha"));
        senha.sendKeys("senha123");

        WebElement botaoEntrar = driver.findElement(By.cssSelector("button[type='submit']"));
        botaoEntrar.click();

        WebDriverWait verificaPagina = new WebDriverWait(driver, Duration.ofSeconds(10));
        verificaPagina.until(ExpectedConditions.urlContains("/dashboard"));
        String urlAtual = driver.getCurrentUrl();
        Assertion.assertTrue(urlAtual.contains("/dashboard"), "A URL deveria conter '/dashboard'");
    }
