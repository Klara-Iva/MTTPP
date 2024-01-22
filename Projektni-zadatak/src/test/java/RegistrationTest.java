import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class RegistrationTest {

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
        driver.findElement(By.xpath("//*[@id=\"newUser\"]")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).clear();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("novi");
        driver.findElement(By.xpath("//input[@id='lastname']")).click();
        driver.findElement(By.xpath("//input[@id='lastname']")).clear();
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("korisnik");
        driver.findElement(By.xpath("//input[@id='userName']")).click();
        driver.findElement(By.xpath("//input[@id='userName']")).clear();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("novi_korisnik");
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("NOVI-korisnik123#");
        Thread.sleep(5000);
        //click recaptcha
        driver.findElement(By.xpath("//*[@id=\"register\"]")).click();
        System.out.print("Registration successful!");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}