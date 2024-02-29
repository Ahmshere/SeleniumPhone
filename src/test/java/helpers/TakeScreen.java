package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static config.BaseTest.getDriver;


public class TakeScreen {

    @Attachment(value = "Failure screenshot", type = "image/png")
    public static  byte[] takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    /*
    takeScreenshot(). Данный метод используется для создания скриншота страницы в случае
    возникновения ошибки во время выполнения теста.

Давайте разберем, что делает каждая часть этого кода:

    public static byte[] takeScreenshot(): Это метод, который возвращает массив байтов (byte[]),
    представляющий скриншот страницы.

    @Attachment(value = "Failure screenshot", type = "image/png"): Это аннотация @Attachment из библиотеки Allure,
     которая указывает, что результат работы метода takeScreenshot() должен быть прикреплен к отчету как вложение (attachment).
      Параметр value указывает название вложения (в данном случае "Failure screenshot"),
       а параметр type указывает тип вложения (в данном случае "image/png").

    return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);: Эта строка кода делает следующее:
        (TakesScreenshot) getDriver(): Приводит объект драйвера к интерфейсу TakesScreenshot,
         который предоставляет метод для создания скриншотов.
        .getScreenshotAs(OutputType.BYTES): Вызывает метод getScreenshotAs(),
         который создает скриншот страницы в виде массива байтов. Параметр OutputType.BYTES указывает,
          что скриншот должен быть представлен в виде массива байтов.

Таким образом, при вызове метода takeScreenshot() будет создан скриншот страницы,
 который затем будет прикреплен к отчету Allure с названием "Failure screenshot" в формате "image/png".

    * */
}
