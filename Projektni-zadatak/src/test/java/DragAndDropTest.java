import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static junit.framework.Assert.assertTrue;

public class DragAndDropTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement droppableElement = driver.findElement(By.id("droppable"));
        WebElement acceptableElement = driver.findElement(By.id("draggable"));
        Actions actions = new Actions(driver);
        actions.moveToElement(acceptableElement).clickAndHold().moveToElement(droppableElement).release().perform();
        Thread.sleep(2000);
        assertTrue(droppableElement.getText().contains("Dropped!"));
        System.out.print("Test successful!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
