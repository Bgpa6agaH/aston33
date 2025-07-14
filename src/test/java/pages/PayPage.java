package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PayPage {

    WebDriver driver;
    WebDriverWait wait;


    By payLocator = By.className("pay");
    By h2Locator = By.tagName("h2");
    By paymentSystemsListLocator = By.className("pay__partners");
    By infoLinkLocator = By.linkText("Подробнее о сервисе");

    By connectionPhoneLocator = By.id("connection-phone");
    By connectionSumLocator = By.id("connection-sum");
    By payConnectionLocator = By.id("pay-connection");
    By buttonDefaultLocator = By.className("button__default");


}
