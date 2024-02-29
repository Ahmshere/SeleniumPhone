package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    /**
     *  Неявное ожидание означает, что Selenium WebDriver будет ожидать наличия элемента на странице
     *  * в течение определенного периода времени перед выбрасыванием исключения NoSuchElementException,
     *  * если элемент не будет найден. Это ожидание применяется ко всем операциям поиска элементов и установлено
     *  * один раз на всю сессию WebDriver.
     * @param args
     */
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
       // driver.manage().window().maximize();
       //  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // Установка неявного ожидания в 10 секунд

        driver.get("https://www.selenium.dev/");
try {
    WebElement element = driver.findElement(By.xpath("//h2[@class='selenium text-center']")); // WebDriver будет ожидать до 10 секунд, если элемент не будет найден сразу
    element.click();
}
catch (NoSuchElementException e){}
finally{
    driver.close();
    driver.quit();
}

    }
}
