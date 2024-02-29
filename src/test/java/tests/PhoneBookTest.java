package tests;

import config.BaseTest;
import helpers.*;
import io.qameta.allure.Allure;
import jdk.jfr.Description;
import model.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PhoneBookTest extends BaseTest {
    @Test
    @Description("Checking an empty field during registration.")
    public void phoneBookTest() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        LoginPage lpage = mainPage.openTopMenuItem(TopMenuItem.LOGIN.toString());
        Alert alert = lpage.fillEmailField("mymegamail@mail.com").clickByRegisterButton();
        String expectedAlertText = "Wrong";
        boolean isAlertHandled = AlertHandler.handleAlert(alert, expectedAlertText);
        if (isAlertHandled) {
            System.out.println("Данные введены правильно.");
        } else {
            System.out.println("Данные введены неправильно или всплывающее окно не появилось.");
        }
        Assert.assertTrue(isAlertHandled);
        Thread.sleep(1000);
    }

    @Test
    @Description("Successful Registration")
    public void successfulRegistration(){
        MainPage mainPage = new MainPage(getDriver());
        LoginPage lpage = mainPage.openTopMenuItem(TopMenuItem.LOGIN.toString());
        lpage.fillEmailField(EmailGenerator.generateEmail(5,5,3)).fillPasswordField(PasswordStringGenerator.generateString());
       Alert alert =  lpage.clickByRegisterButton();
        if (alert==null){
            ContactsPage contactsPage = new ContactsPage(getDriver());
            Assert.assertTrue( contactsPage.isElementPersist(getDriver().findElement(By.xpath("//button[contains(text(),'Sign Out')]"))));
        }else {}
    }

    @Test
    @Description("User already exist. Login and add contact.")
    public void loginOfAnExistingUserAddContact() throws InterruptedException {
        Allure.description("User already exist. Login and add contact.!");
        MainPage mainPage = new MainPage(getDriver());
        Allure.step("Step 1");
        LoginPage lpage = mainPage.openTopMenuItem(TopMenuItem.LOGIN.toString());
        lpage.fillEmailField(PropertiesReader.getProperty("existingUserEmail"))
                .fillPasswordField(PropertiesReader.getProperty("existingUserPassword"))
                .clickByLoginButton();
        MainPage.openTopMenuItem(TopMenuItem.ADD.toString());
        AddPage addPage = new AddPage(getDriver());
        Contact newContact = new Contact(NameLastNameGenerator.generateName(),
                NameLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(),
                EmailGenerator.generateEmail(10,5,3),
                AddressGenerator.generateAddress(),
                "new description");
        newContact.toString();
        addPage.fillFormAndSave(newContact);
        ContactsPage contactsPage = new ContactsPage(getDriver());
        Assert.assertTrue(contactsPage.getDataFromContactList(newContact));
        TakeScreen.takeScreenshot();
        Thread.sleep(5000);

    }
    @Test
    @Description("Registration of an already registered user")
    public void registrationOfAnAlreadyRegisteredUser(){
        Allure.description("Registration of an already registered user!");
        MainPage mainPage = new MainPage(getDriver());
        LoginPage lpage = mainPage.openTopMenuItem(TopMenuItem.LOGIN.toString());
        Alert alert = lpage.fillEmailField(PropertiesReader.getProperty("existingUserEmail"))
                .fillPasswordField(PropertiesReader.getProperty("existingUserPassword")).clickByRegisterButton();
        String expectedAlertText = "User already exist";
        boolean isAlertHandled = AlertHandler.handleAlert(alert, expectedAlertText);
        Assert.assertTrue(isAlertHandled);

    }


}
