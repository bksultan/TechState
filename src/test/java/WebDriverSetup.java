import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetup {
    static WebDriver driver = new ChromeDriver();

    @Test
    public void setup(){
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.xpath("//input[@id='user-name']"));
        login.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement fleeceJacket = driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']"));
        System.out.println(fleeceJacket.getText());

        String nameOfItem = fleeceJacket.getText();
        Assert.assertEquals("Sauce Labs Fleece Jacket", nameOfItem);

    }
}
