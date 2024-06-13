package class2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    static WebDriver driver = new ChromeDriver();

    @Test
    public void setup() {
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Beksultan Ismatov");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("beksultan@gmail.com");

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        textarea.sendKeys("Hello Techstate");

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
    }
}
