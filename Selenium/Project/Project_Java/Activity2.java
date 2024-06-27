package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Navigate to the website
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the heading of the webpage
        String heading = driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']")).getText();

        // Verify the website heading
        if (heading.equals("Welcome to Alchemy Jobs")) {
            System.out.println("Website heading matches: " + heading);
        } else {
            System.out.println("Website heading does not match: " + heading);
        }

        // Close the browser
        driver.quit();
    }
}
