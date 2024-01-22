import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest {

    public WebDriver driver;
    public String testURL = "https://demoqa.com/login";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("novi_korisnik");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("NOVI-korisnik123#");
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        System.out.print("Login successful!");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}