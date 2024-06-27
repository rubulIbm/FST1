package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestStepsMultipleData {
        WebDriver driver;
        WebDriverWait wait;

        @Given("^User is on Login page to test Muplie data")
        public void loginPage() {
            //Setup instances
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            wait = new WebDriverWait(driver, 10);

            //Open browser
            driver.get("https://v1.training-support.net/selenium/login-form");
        }


        @When("User enters {string} and {string}to test Muplie data")
        public void user_enters_and(String username, String password) throws Throwable {
            //Enter username from Feature file
            driver.findElement(By.id("username")).sendKeys(username);
            //Enter password from Feature file
            driver.findElement(By.id("password")).sendKeys(password);
            //Click Login
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }

        @Then("^Read the page title and confirmation message to test Muplie data")
        public void readTitleAndHeading() {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

            //Read the page title and heading
            String pageTitle = driver.getTitle();
            String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

            //Print the page title and heading
            System.out.println("Page title is: " + pageTitle);
            System.out.println("Login message is: " + confirmMessage);

            if(confirmMessage.contains("admin")) {
                Assert.assertEquals(confirmMessage, "Welcome Back, admin");
            } else {
                Assert.assertEquals(confirmMessage, "Invalid Credentials");
            }
        }

        @And("^Close the Browser to test Muplie data")
        public void closeBrowser() {
            //Close browser
            driver.close();
        }

    }
