package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Navigate to the website
        driver.get("https://alchemy.hguy.co/jobs/");

        // Find the navigation bar
        WebElement navBar = driver.findElement(By.xpath("//div[@class='main-header-bar-navigation']"));

        // Select the menu item that says "Jobs" and click it
        WebElement jobsMenuItem = navBar.findElement(By.linkText("Jobs"));
        jobsMenuItem.click();

        // Wait for the page title to contain "Jobs"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Jobs"));

        // Read the page title
        String pageTitle = driver.getTitle();

        // Verify that you are on the correct page
        if (pageTitle.contains("Jobs")) {
            System.out.println("Navigated to the correct Jobs page. Page title: " + pageTitle);
        } else {
            System.out.println("Did not navigate to the correct Jobs page. Page title: " + pageTitle);
        }

        // Close the browser
        driver.quit();

    }
}
