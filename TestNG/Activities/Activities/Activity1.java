package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

        WebDriver driver;

        @BeforeClass
        public void beforeMethod() {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();

            //Open browser
            driver.get("https://v1.training-support.net");
        }

        @Test
        public void exampleTestCase() throws InterruptedException {
            Thread.sleep(2000);
            // Check the title of the page
            String title = driver.getTitle();

            //Print the title of the page
            System.out.println("Page title is: " + title);

            //Assertion for page title
            Assert.assertEquals("Training Support", title);

            //Find the clickable link on the page and click it
            driver.findElement(By.id("about-link")).click();

            //Print title of new page
            System.out.println("New page title is: " + driver.getTitle());

            Assert.assertEquals(driver.getTitle(), "About Training Support");
        }

        @AfterClass
        public void afterMethod() {
            //Close the browser
            driver.close();
        }

    }
