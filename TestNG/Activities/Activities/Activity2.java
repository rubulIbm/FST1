package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create a new instance of the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Open browser and navigate to the URL
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void testGetTitle() {
        // Get and assert the title of the page
        String title = driver.getTitle();
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testFindBlackButton() {
        // Look for the black button and make an incorrect assertion
        try {
            driver.findElement(By.id("blackButton")).click(); // Assuming the button has an id of "blackButton"
            Assert.assertTrue(false, "Black button was clicked.");
        } catch (Exception e) {
            Assert.assertTrue(true, "Black button was not found.");
        }
    }

    @Test(enabled = false)
    public void testSkipMethod1() {
        // This test method will be skipped
        System.out.println("This test method will be skipped but will not be shown as skipped.");
    }

    @Test
    public void testSkipMethod2() {
        // Skip the test method by throwing a SkipException
        throw new SkipException("Skipping this test method intentionally.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}
