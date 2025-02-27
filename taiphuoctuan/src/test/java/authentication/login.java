package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.Keys;

public class login {
    public static void main(String[] args) {
        // Setup WebDriverManager to manage the driver binary
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions to configure ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-web-security");

        // Create a new instance of the Chrome driver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open Google
            driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");

            // // Find the search box using its name attribute
            // WebElement searchBox = driver.findElement(By.name("q"));

            // // Enter a search query
            // searchBox.sendKeys("Selenium WebDriver");

            // // Submit the search form
            // searchBox.submit();

            // Wait for the results to load

            WebElement button = driver
                    .findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button"));
            button.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]")

            ));
            userName.sendKeys("phuoc.2174802010334@vanlanguni.vn", Keys.ENTER);
            WebElement passName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input")

            ));
            passName.sendKeys("VLU30042003", Keys.ENTER);
            WebElement tiepTuc = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input")

            ));
            tiepTuc.click();
            wait.until(ExpectedConditions.urlContains("Phancong02")); // Thay bằng URL trang sau khi login

            System.out.println("Đăng nhập thành công!");

        }
        finally {
        // Close the browser
        driver.quit();
        }
    }
}
