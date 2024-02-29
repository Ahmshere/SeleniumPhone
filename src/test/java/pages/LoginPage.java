package pages;

import helpers.AlertHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends  BasePage{
@FindBy(xpath = "//input[@name='email']")
    WebElement emailField;
@FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
@FindBy(xpath = "//button[@name='registration']")
WebElement registrationButton;
@FindBy(xpath = "//button[@name='login']")
WebElement loginButton;
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    // Дополнительные методы и поля, специфичные для страницы About
    public LoginPage fillEmailField(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage fillPasswordField(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public String getAlertText() {
        AlertHandler alertHandler = new AlertHandler(driver);

        // Вызываем метод для обработки всплывающего окна
        String alertText = alertHandler.getAlertText();
        System.out.println("Текст всплывающего окна: " + alertText);
        return alertText;
    }

    public Alert clickByRegisterButton() {

        registrationButton.click();

        return getAlertIfPresent();
    }
    private Alert getAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            // Обработка ситуации, когда окно предупреждения не появляется
            System.out.println("Окно предупреждения не появилось в течение 5 секунд.");
            return null; // Или выполните другие действия, в зависимости от вашего случая
        }
    }

    public BasePage clickByLoginButton() {
        loginButton.click();
        Alert alert = getAlertIfPresent();
        if (alert != null) {
            alert.accept();
            return new LoginPage(driver);
        } else {
            return new ContactsPage(driver);
        }
    }

}
