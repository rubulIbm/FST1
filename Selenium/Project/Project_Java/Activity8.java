package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
// Navigate to the site’s backend
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Find the username field of the login form and enter the username
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys("root");

        // Find the password field of the login form and enter the password
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys("pa$$w0rd");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();

        // Verify that you have logged in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Dashboard"));

        if (driver.getTitle().contains("Dashboard")) {
            System.out.println("Logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }

        // Close the browser
        driver.quit();
    }
}