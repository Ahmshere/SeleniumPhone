package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    /**
     * Этот код представляет конструктор класса HomePage. Давайте рассмотрим его по частям:
     *
     *     public HomePage(WebDriver driver): Это объявление конструктора класса HomePage,
     *     который принимает объект WebDriver в качестве параметра. Конструктор выполняется
     *     при создании нового объекта HomePage.
     *
     *     setDriver(driver): Это вызов метода setDriver(),
     *     который устанавливает экземпляр WebDriver для данной страницы.
     *     Возможно, что этот метод устанавливает внутреннее состояние объекта HomePage,
     *     чтобы он мог использовать переданный WebDriver.
     *
     *     PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this):
     *     Эта строка инициализирует элементы страницы с использованием Selenium PageFactory.
     *     PageFactory - это класс в Selenium, который помогает автоматически находить и инициализировать
     *     элементы на веб-странице, связывая их с полями класса.
     *     В данном случае, initElements инициализирует элементы этой страницы (this)
     *     с помощью AjaxElementLocatorFactory, которая позволяет искать элементы динамически на странице.
     *     Параметр driver указывает WebDriver, который будет использоваться для поиска элементов,
     *     а число 20 - это таймаут ожидания в секундах, указывающий,
     *     сколько времени WebDriver будет ожидать появления элементов на странице,
     *     прежде чем сгенерировать исключение.
     */
}
