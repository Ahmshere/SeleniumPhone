package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;
    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }




/**
 * Этот фрагмент кода содержит определение класса BasePage, который служит базовым классом для всех страниц вашего тестового приложения,
 * использующего библиотеку Selenium для автоматизации веб-тестирования.
 *
 *     import org.openqa.selenium.WebDriver;: Эта строка импортирует класс WebDriver из пакета org.openqa.selenium.
 *     Класс WebDriver является ключевым интерфейсом в Selenium, предоставляющим методы для управления браузером.
 *
 *     public class BasePage {: Это объявление класса BasePage.
 *     Ключевое слово public означает, что класс доступен из любого другого класса.
 *     BasePage является базовым классом для страниц вашего приложения.
 *
 *     protected static WebDriver driver;: Это объявление статического поля driver типа WebDriver.
 *     Поле driver предназначено для хранения экземпляра веб-драйвера, который будет использоваться для управления браузером на страницах.
 *
 *     public static void setDriver(WebDriver webDriver){:
 *     Это объявление статического метода setDriver, который принимает параметр webDriver типа WebDriver.
 *     Метод устанавливает значение поля driver в переданный экземпляр веб-драйвера.
 *
 *     driver = webDriver;: Эта строка присваивает переданный экземпляр веб-драйвера переменной driver,
 *     что позволяет другим классам иметь доступ к этому веб-драйверу через метод getDriver(), если они импортировали класс BasePage.
 *
 * Этот класс BasePage предоставляет базовую функциональность для управления веб-драйвером в
 * тестовых страницах вашего приложения, такую как инициализация веб-драйвера и установка его для использования на страницах.
 */

public static boolean isElementPresent(WebElement element) {
    try {
        // Попытка выполнить любое действие с элементом
        element.isDisplayed();
        return true; // Элемент присутствует на странице
    } catch (NoSuchElementException | NullPointerException e) {
        return false; // Элемент не найден на странице
    }
}
}