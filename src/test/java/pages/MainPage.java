package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPage extends BasePage{
    @FindBy(xpath = "//a[contains(text(),'HOME')]")
    WebElement homeTopMenuItem;
    @FindBy(xpath = "//a[contains(text(),'ABOUT')]")
    WebElement aboutTopMenuItem;
    @FindBy(xpath = "//a[contains(text(),'LOGIN')]")
    WebElement loginTopMenuItem;

    /**
     *     public MainPage(WebDriver driver) { - Объявляет конструктор класса MainPage, который принимает объект WebDriver в качестве параметра.
     *     setDriver(driver); - Устанавливает переданный объект WebDriver в качестве драйвера для экземпляра класса MainPage.
     *, метод setDriver присваивает переданный драйвер переменной driver в родительском классе или где-то еще внутри класса MainPage.
     *
     *     driver.get("https://telranedu.web.app/home"); - Переходит на указанный URL-адрес веб-страницы с помощью метода get объекта WebDriver.
     *     В данном случае, браузер открывает страницу по адресу "https://telranedu.web.app/home".
     *
     *     PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
     *     - Инициализирует элементы страницы с помощью PageFactory.
     *     Она ищет все аннотированные элементы @FindBy в классе MainPage и связывает их с реальными элементами веб-страницы.
     *     Используется AjaxElementLocatorFactory для ожидания элементов до их появления на странице в течение указанного времени (в данном случае, 20 секунд).
     *
     * Этот конструктор выполняет инициализацию страницы MainPage, устанавливает драйвер,
     * переходит на указанную страницу и инициализирует все элементы страницы, готовя ее к дальнейшему использованию в тестах.
     */

    public MainPage(WebDriver driver){
        setDriver(driver);
        driver.get("https://telranedu.web.app/home");
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    /**
     * Эта строка представляет обобщённый метод в Java. Давайте разберём её:
     *
     *     public: Это модификатор доступа, который указывает, что метод доступен для использования из любого места в коде.
     *
     *     <T extends BasePage>: Это обобщённый тип данных. Он объявляет тип T,
     *     который является подтипом класса BasePage или самим классом BasePage.
     *     Это позволяет нам использовать любой подкласс BasePage в качестве типа возвращаемого значения.
     *     Например, если у нас есть подклассы HomePage, AboutPage, LoginPage и AddPage, мы можем использовать этот метод для возврата любого из этих типов.
     *
     *     T: Это тип возвращаемого значения метода. Он означает, что метод будет возвращать объект типа T.
     *
     *     openTopMenuItem(String topMenuItem): Это имя метода. Метод принимает строковый параметр topMenuItem,
     *     который представляет собой элемент меню, который нужно открыть.
     *
     * Таким образом, эта строка кода означает, что мы объявляем обобщённый метод с именем openTopMenuItem,
     * который принимает строковый параметр topMenuItem и возвращает объект типа T, который является подтипом класса BasePage или самим классом BasePage.
     */
    public static <T extends BasePage> T openTopMenuItem(String topMenuItem) {
        WebElement menuItem = driver.findElement(By.xpath("//a[contains(text(),'" + topMenuItem + "')]"));
        menuItem.click();

        // Возвращаем объект страницы в зависимости от переданного параметра
        /**
         * Строка return (T) new HomePage(driver); является примером использования обобщенного программирования в Java. Давайте разберем ее:
         *     return: Это ключевое слово в Java, которое используется для возврата значения из метода.
         *     (T): Это оператор приведения типа (type casting). В данном случае (T) означает, что мы приводим созданный объект к типу T.
         *
         *     new HomePage(driver): Это оператор создания нового объекта класса HomePage.
         *     Здесь driver передается в качестве аргумента конструктору класса HomePage.
         */
        switch (topMenuItem) {
            case "HOME":
                return (T) new HomePage(driver);
            case "ABOUT":
                return (T) new AboutPage(driver);
            case "LOGIN":
                return (T) new LoginPage(driver);
            case"CONTACTS":
                return (T) new ContactsPage(driver);
            case "ADD":
                return (T) new AddPage(driver);
            default:
                throw new IllegalArgumentException("Invalid topMenuItem: " + topMenuItem);
        }
    }

}
