package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        //Navigate to the website
        driver.get("https://alchemy.hguy.co/jobs/");

        // Get the URL of the header image
        String headerImageUrl = driver.findElement(By.xpath("//img[contains(@class, 'attachment-large')]")).getAttribute("src");

        // Print the URL of the header image to the console
        System.out.println("Header image URL: " + headerImageUrl);

        // Close the browser
        driver.quit();
    }
}
