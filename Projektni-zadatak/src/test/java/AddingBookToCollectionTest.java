import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingBookToCollectionTest {
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
        Thread.sleep(7000);
        WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
        element2.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='searchBox']")).click();
        driver.findElement(By.xpath("//input[@id='searchBox']")).clear();
        driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("java");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Learning JavaScript Design Patterns')]")).click();
        WebElement element3 = driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
        element3.click();
        Thread.sleep(5000);
        System.out.print("Adding book successful!");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}