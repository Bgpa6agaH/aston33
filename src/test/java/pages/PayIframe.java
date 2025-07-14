package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PayIframe {

    WebDriver driver;
    WebDriverWait wait;

    By bepaidIframeLocator = By.className("bepaid-iframe");
    By titleLocator = By.tagName("title");
    By creditCardLocator = By.cssSelector("input[formcontrolname='creditCard']");
    By expirationDateLocator = By.cssSelector("input[formcontrolname='expirationDate']");
    By cvcLocator = By.cssSelector("input[formcontrolname='cvc']");
    By holderLocator = By.cssSelector("input[formcontrolname='holder']");
    By buttonLocator = By.xpath("//button[contains(text(), 'Оплатить')]");


}
