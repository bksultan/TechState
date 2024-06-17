package class2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static utilities.WebUtils.*;

public class OrangeCRM {

    @BeforeAll
    public static void LoginTest() throws InterruptedException {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        sendKeysToElement(By.xpath("//input[@name='username']"), "Admin", Duration.ofSeconds(10));
        sendKeysToElement(By.xpath("//input[@name='password']"), "admin123", Duration.ofSeconds(10));
        clickElement(By.xpath("//button[@type='submit']"), Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void systemUsersSearchFunctionality() {
        clickElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"), Duration.ofSeconds(10));
        sendKeysToElement(By.xpath("//label[.='Username']/parent::div/following-sibling::div/input"), "admin123", Duration.ofSeconds(10));
        clickElement(By.xpath("//button[@type='submit']"), Duration.ofSeconds(10));

        clickElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']"), Duration.ofSeconds(10));

        List<WebElement> userNavigation = waitForListElements(By.xpath("//div[@role='tablist']//a"), Duration.ofSeconds(10));
        for (WebElement e : userNavigation) {
            System.out.println(e.getText());
        }
    }

}
