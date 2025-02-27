package testRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testthucoichayduockhong {
    public static void main(String[] args) {
        // Setup WebDriverManager to manage the driver binary
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Find the search box using its name attribute
            WebElement searchBox = driver.findElement(By.name("q"));

            // Enter a search query
            searchBox.sendKeys("Selenium WebDriver");

            // Submit the search form
            searchBox.submit();

            // Wait for the results to load
            Thread.sleep(2000);

            // Print the title of the page
            System.out.println("Page title is: " + driver.getTitle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}