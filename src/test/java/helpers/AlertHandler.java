package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandler {

    private WebDriver driver;

    public AlertHandler(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean handleAlert(Alert alert, String expectedText) {
        if (alert != null) {
            String alertText = alert.getText();
            System.out.println("Текст всплывающего окна: " + alertText);
            alert.accept();
            return alertText.contains(expectedText);
        } else {
            System.out.println("Всплывающее окно не появилось.");
            return false;
        }
    }

    public String getAlertText() { // Метод getAlertText(), который возвращает текст всплывающего окна.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Подождите максимум 10 секунд
        // Создание объекта WebDriverWait с параметром driver и временем ожидания 10 секунд.  О Ожиданиях!
        // Ожидаем появления Alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // Использование объекта wait для ожидания появления всплывающего окна.
        // Метод until() будет ждать, пока условие alertIsPresent() не станет истинным, и затем вернет объект Alert.
        alert = driver.switchTo().alert(); //Переключение фокуса на всплывающее окно с помощью метода switchTo().alert().
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
