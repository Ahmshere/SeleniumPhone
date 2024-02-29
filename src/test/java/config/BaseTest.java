package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.AllureResultsWriter;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.BasePage;


import java.time.Duration;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    // ThreadLocal - это класс в Java, который позволяет создавать локальные переменные, специфичные для каждого потока.
    // Каждый поток имеет свою собственную копию переменной, хранящейся в ThreadLocal, и доступ может быть получен только из соответствующего потока.
    // Это полезно, когда вам нужно создать объект, который будет уникальным для каждого потока, и при этом изолировать состояние между потоками.

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
        // Короче говоря, метод getDriver() предоставляет общий способ получения экземпляра WebDriver,
        // который хранится в ThreadLocal, в любой части вашего кода
    }
        /*ИЛИ *//*
         private WebDriver driver;
         public WebDriver getDriver() {
               return driver;
         }
         */

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
           // WebDriverManager.chromedriver().browserVersion("121.0.6167.185").setup();

            // Настройки для Chrome
            WebDriverManager.chromedriver().setup();
            // WebDriverManager используется для автоматической загрузки и настройки драйвера!
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--no-sandbox"); // Добавьте эти опции для обхода некоторых проблем с запуском на Windows
            options.addArguments("--disable-dev-shm-usage");
            //  WebDriver driver = new ChromeDriver(options);

            // options.addArguments("--headless");
            options.addArguments("--lang=en");
            options.addArguments("--disable-gpu");


             driverThreadLocal.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {
            // Настройки для Firefox
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("intl.accept_languages", "en");
            // options.addArguments("-headless"); // setHeadless(true);
            driverThreadLocal.set(new FirefoxDriver(options));
        } else {
            throw new IllegalArgumentException("Invalid browser value: " + browser);
        }

        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        BasePage.setDriver(driver);
        /**
         *     WebDriver driver = getDriver();: Здесь создается переменная driver, которая получает экземпляр объекта WebDriver
         *     с помощью вызова метода getDriver(). Этот метод возвращает экземпляр WebDriver, сохраненный в ThreadLocal,
         *     что позволяет каждому потоку иметь свой собственный экземпляр драйвера.
         *
         *     driver.manage().window().maximize();: Этот вызов используется для максимизации окна браузера,
         *     чтобы оно занимало максимально возможное пространство на экране.
         *
         *     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));: Здесь устанавливается время ожидания для загрузки страницы.
         *     Если страница не загружается в течение указанного времени (в данном случае, 20 секунд), будет сгенерировано исключение.
         *
         *     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));: Этот вызов устанавливает неявное ожидание.
         *     Если элемент не найден сразу, WebDriver будет ждать указанное время (в данном случае, 20 секунд), прежде чем выбросить исключение.
         *
         *     BasePage.setDriver(driver);: Этот вызов используется для установки экземпляра драйвера в базовом классе страницы.
         *     Это может быть полезно, если у вас есть базовый класс для всех ваших страниц, который управляет инициализацией драйвера.
         *
         * Таким образом, эти строки кода выполняют инициализацию драйвера, настройку его параметров (размер окна, тайм-ауты ожидания)
         * и передачу его в базовый класс страницы для дальнейшего использования в тестах.
         */


    }


    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

}

/*
package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.BasePage;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--lang=en");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("intl.accept_languages", "en");
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Invalid browser value: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



* */