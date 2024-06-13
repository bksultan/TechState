package class2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeCRM {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void LoginTest() throws InterruptedException {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
    }

    @Test
    public void systemUsersSearchFunctionality() throws InterruptedException {
        String usernameForSearch = "Admin";
        Thread.sleep(4000);
        WebElement adminButton = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
        adminButton.click();

        Thread.sleep(4000);
        WebElement username = driver.findElement(By.xpath("//label[.='Username']/parent::div/following-sibling::div/input"));
        username.sendKeys(usernameForSearch);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();


    }

}
