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

public class AddMajorTest {
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

            // Wait for Add Major button and click it
            WebElement addMajorButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")));
            addMajorButton.click();

            // Enter major name and code
            WebElement majorId = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")));
            majorId.sendKeys("0012");

            WebElement majorName = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")));
            majorName.sendKeys("CNCdSATT");

            // Enter Term (if required)
            WebElement majorabbreviation = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")));
            majorabbreviation.sendKeys("CSfdDT");
            WebElement curriculumDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span/span[1]/span/span[1]")));
            curriculumDropdown.click();
                WebElement selectCurriculum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/span/span[2]/ul/li[2]")));
                    selectCurriculum.click();

            // // Enter Term (if required)
            // WebElement termField = driver.findElement(By.id("term"));
            // termField.sendKeys("2024-2025");
            
            // Click Save
            WebElement saveButton =  wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")));
            saveButton.click();
            
            // Verify major is added
            try {
                WebElement successPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div")));
                if (successPopup.isDisplayed()) {
                    System.out.println("Thêm ngành thất bại!");
                }
            } catch (Exception e) {
                System.out.println("Thêm ngành thành công!");
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
