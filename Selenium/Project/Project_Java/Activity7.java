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

public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
// Navigate to the Alchemy Jobs site
        driver.get("https://alchemy.hguy.co/jobs/");

        // Locate the navigation menu and click the menu item that says “Post a Job”
        WebElement postJobMenuItem = driver.findElement(By.linkText("Post a Job"));
        postJobMenuItem.click();

        // Fill in the necessary details
        WebElement jobTitle = driver.findElement(By.id("job_title"));
        jobTitle.sendKeys("Test Job");

        WebElement jobDescriptionFrame = driver.findElement(By.id("job_description_ifr"));
        driver.switchTo().frame(jobDescriptionFrame);
        WebElement jobDescription = driver.findElement(By.id("tinymce"));
        jobDescription.sendKeys("This is a test job description.");
        driver.switchTo().defaultContent();

        WebElement jobTypeDropdown = driver.findElement(By.id("job_type"));
        Select jobTypeSelect = new Select(jobTypeDropdown);
        jobTypeSelect.selectByVisibleText("Full Time");

        WebElement jobLocation = driver.findElement(By.id("job_location"));
        jobLocation.sendKeys("Remote");

        // Click the button that says “Preview”
        WebElement previewButton = driver.findElement(By.name("continue"));
        previewButton.click();

        // Click on the button that says “Submit Listing”
        WebElement submitListingButton = driver.findElement(By.name("submit_job"));
        submitListingButton.click();

        // Verify that the job listing was posted by visiting the jobs page
        driver.get("https://alchemy.hguy.co/jobs/jobs/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("job_listing"), "Test Job"));

        if (driver.getPageSource().contains("Test Job")) {
            System.out.println("Job listing was posted successfully.");
        } else {
            System.out.println("Job listing was not posted.");
        }

        // Close the browser
        driver.quit();
    }
}
