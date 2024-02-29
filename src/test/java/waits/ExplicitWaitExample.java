package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 Явное (Explicit) ожидание
Явное ожидание позволяет задать условие ожидания для определенного элемента на странице.
 То есть, вы устанавливаете ожидание только для конкретных событий и условий.
 Явное ожидание используется с помощью класса WebDriverWait в сочетании с ожидаемыми условиями из класса ExpectedConditions.

 */
public class ExplicitWaitExample {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
try {
    WebElement element = driver.findElement(By.xpath("//h2[@class='selenium text-center']"));
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0)); // Установка явного ожидания на * секунд
    // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='selenium text-center']"))); // WebDriver будет ждать до 10 секунд, пока элемент не станет видимым

    element.click(); }
catch (NoSuchElementException e){}
finally{
    driver.close();
    driver.quit();
}



    }
}
