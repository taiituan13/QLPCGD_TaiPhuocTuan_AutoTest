package majorManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteMajorTest {
    public static void main(String[] args) {
        // Setup WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-web-security");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Mở cửa sổ tối đa
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open login page
            driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");

            // Click login button
            WebElement button = driver
                    .findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button"));
            button.click();

            // Enter username
            WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]")));
            userName.sendKeys("tuan.2174802010873@vanlanguni.vn", Keys.ENTER);

            // Enter password
            WebElement passName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input")));
            passName.sendKeys("VLU14042003", Keys.ENTER);

            // Click continue
            WebElement tiepTuc = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input")));
            tiepTuc.click();
            wait.until(ExpectedConditions.urlContains("Phancong02"));

            System.out.println("Đăng nhập thành công!");

            // Navigate to Major Management
            WebElement majorMenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Học kỳ và ngành")));
            majorMenu.click();

            WebElement major = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")));
            major.click();
             // Delete major
             WebElement searchMajor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")));
             searchMajor.sendKeys("0012");
             
             WebElement deleteMajorButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[2]/i")));
             deleteMajorButton.click();
             
             WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/button[1]")));
             confirmDeleteButton.click();
             
             // Verify deletion
             try {
                 WebElement successDeletePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div")));
                 if (successDeletePopup.isDisplayed()) {
                     System.out.println("Xóa ngành thành công!");
                 }
             } catch (Exception e) {
                 System.out.println("Xóa ngành thất bại!");
             }
         } catch (Exception e) {
             System.err.println("Lỗi xảy ra: " + e.getMessage());
             e.printStackTrace();
        } finally {
            // Close browser
            // driver.quit();
        }
    }
}
