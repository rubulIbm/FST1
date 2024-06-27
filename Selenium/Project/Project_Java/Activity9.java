package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Navigate to the backend login page and log in
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        WebElement loginButton = driver.findElement(By.id("wp-submit"));

        usernameField.sendKeys("root");
        passwordField.sendKeys("pa$$w0rd");
        loginButton.click();

        // Locate the left-hand menu and click the menu item that says “Job Listings”
        WebElement jobListingsMenu = driver.findElement(By.xpath("//div[contains(@class, 'wp-menu-name') and text()='Job Listings']"));
        jobListingsMenu.click();

        // Locate the “Add New” button and click it
        WebElement addNewButton = driver.findElement(By.xpath("//a[@class='page-title-action']"));
        addNewButton.click();

        // Fill in the necessary details
        WebElement jobTitle = driver.findElement(By.id("job_title"));
        jobTitle.sendKeys("Backend Test Job");

        WebElement jobDescriptionFrame = driver.findElement(By.id("job_description_ifr"));
        driver.switchTo().frame(jobDescriptionFrame);
        WebElement jobDescription = driver.findElement(By.id("tinymce"));
        jobDescription.sendKeys("This is a backend test job description.");
        driver.switchTo().defaultContent();

        WebElement jobTypeDropdown = driver.findElement(By.id("job_type"));
        Select jobTypeSelect = new Select(jobTypeDropdown);
        jobTypeSelect.selectByVisibleText("Full Time");

        WebElement jobLocation = driver.findElement(By.id("job_location"));
        jobLocation.sendKeys("Backend Location");

        // Click the “Publish” button
        WebElement publishButton = driver.findElement(By.id("publish"));
        publishButton.click();

        // Verify that the job listing was created
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='message']/p[contains(text(), 'Post published')]")));

        if (driver.getPageSource().contains("Backend Test Job")) {
            System.out.println("Job listing was created successfully.");
        } else {
            System.out.println("Job listing was not created.");
        }

        // Close the browser
        driver.quit();
    }
}
