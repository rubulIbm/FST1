package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the second heading on the page
        String secondHeading = driver.findElement(By.xpath("(//h2)[1]")).getText();

        // Verify the website's second heading
        if (secondHeading.equals("Quia quis non")) {
            System.out.println("Second heading matches: " + secondHeading);
        } else {
            System.out.println("Second heading does not match: " + secondHeading);
        }

        // Close the browser
        driver.quit();
    }
}
