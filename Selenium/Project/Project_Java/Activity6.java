package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/jobs/");

        // Search for a particular job (e.g., "Automation Engineer")
        WebElement searchJob = driver.findElement(By.id("search_keywords"));
        searchJob.sendKeys("Automation Engineer");
        searchJob.submit();

        // Wait for the job listings to show
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("job_listing")));

        // Click and open any one of the jobs listed
        WebElement jobListing = driver.findElement(By.xpath("//ul[@class='job_listings']"));
        jobListing.click();

        // Click the apply button
        WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply for job']"));
        applyButton.click();

        // Print the email to the console
        WebElement emailElement = driver.findElement(By.cssSelector(".job_application_email"));
        String email = emailElement.getText();
        System.out.println("Job application email: " + email);

        // Close the browser
        driver.quit();
    }
}
