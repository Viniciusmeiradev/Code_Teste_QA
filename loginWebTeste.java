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
