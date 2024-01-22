import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProgressBarTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/progress-bar");
    }

    @Test
    public void testProgressBarStartStopButton() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement progressBar = driver.findElement(By.id("progressBar"));
        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();
        int targetNumber=23;
        waitForProgressBarToReachPercentage(progressBar, targetNumber);
        startStopButton.click();
        Thread.sleep(1000);
        int progressBarValue = getProgressBarPercentage(progressBar);
        System.out.printf("Progress bar stopped at: %d, expected value was: %d", progressBarValue, targetNumber);
    }

    private void waitForProgressBarToReachPercentage(WebElement progressBar, int targetPercentage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) driver ->  getProgressBarPercentage(progressBar) >= targetPercentage);
    }

    private int getProgressBarPercentage(WebElement progressBar) {
        String script = "return arguments[0].querySelector('.progress-bar').getAttribute('aria-valuenow')";
        String percentageValue = ((JavascriptExecutor) driver).executeScript(script, progressBar).toString();
        return Integer.parseInt(percentageValue);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
