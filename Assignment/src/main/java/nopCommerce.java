import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class nopCommerce {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/admin/");
        driver.findElement(By.xpath("//input[@name='Email']")).clear();
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("admin@yourstore.com");
        driver.findElement(By.xpath("//input[@name='Password']")).clear();
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("admin@yourstore.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expecteHeaders="Dashboard";
        String actualHeader=driver.findElement(By.xpath("//div[@class='content-header']/h1")).getText();
        Assert.assertEquals(expecteHeaders,actualHeader);
        driver.findElement(By.xpath("//ul[@role='menu']/li[4]/a/p")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='menu']/li[4]/ul/li[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //input[@name='SearchFirstName']")).sendKeys("FirstName");
        driver.findElement(By.xpath(" //input[@name='SearchLastName']")).sendKeys("LastName");
        driver.findElement(By.xpath("//button[@id='search-customers']")).click();

    }
}
