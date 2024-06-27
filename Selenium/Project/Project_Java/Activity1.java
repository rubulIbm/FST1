package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
        String title = driver.getTitle();
        // Verify the website title
        if (title.equals("Alchemy Jobs – Job Board Application")) {
            System.out.println("Website title matches: " + title);
        } else {
            System.out.println("Website title does not match: " + title);
        }
        // Close the browser
        driver.quit();
    }

}
