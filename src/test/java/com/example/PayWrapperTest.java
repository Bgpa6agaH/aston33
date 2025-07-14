package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


/*

1) Проверить название указанного блока;
2) Проверить наличие логотипов платёжных систем;
3)Проверить работу ссылки «Подробнее о сервисе»;
4)Заполнить поля и проверить работу кнопки «Продолжить»
(проверяем только вариант «Услуги связи», номер для теста 297777777)
 */

public class PayWrapperTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement paySection;


    @BeforeClass
    void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement cookieAcceptElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))
        );
        cookieAcceptElement.click();
    }

    @BeforeMethod
    public void setUp() {
        By payLocator = By.className("pay");
        this.paySection = wait.until(
                ExpectedConditions.presenceOfElementLocated(payLocator)
        );
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }


//1) Проверить название указанного блока;

    @Test
    public void testPayWrapperTitle() {

        WebElement h2Element = paySection.findElement(By.tagName("h2"));
        String h2Text = h2Element.getText();
        Assert.assertEquals(h2Text, "Онлайн пополнение\nбез комиссии",
                "Название блока отличается от 'Онлайн пополнение без комиссии'");
    }

    //2) Проверить наличие логотипов платёжных систем;
    @Test
    public void testPayWrapperLogos() {
        WebElement paymentSystemsList = paySection.findElement(By.className("pay__partners"));
        var listItems = paymentSystemsList.findElements(By.tagName("li"));

        Assert.assertFalse(listItems.isEmpty(), "Список платежных систем пуст");
        for (WebElement item : listItems) {
            WebElement image = item.findElement(By.tagName("img"));
            String src = image.getAttribute("src");
            String text = image.getAttribute("alt");

            Assert.assertNotNull(src, "У логотипа платежной системы отсутствует src атрибут.");
            Assert.assertFalse(src.isEmpty(), "src атрибут логотипа платежной системы пуст.");

            Assert.assertTrue(image.isDisplayed(), "Логотип платежной системы не отображается.");
            Assert.assertTrue(isImageLoaded(image), "Логотип платежной системы не загрузился.");

            Assert.assertNotNull(text, "У логотипа платежной системы отсутствует alt атрибут.");
            Assert.assertFalse(text.isEmpty(), "Alt атрибут логотипа платежной системы пуст.");

        }
    }

    private boolean isImageLoaded(WebElement imageElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Long naturalWidth =
                (Long) jsExecutor.executeScript("return arguments[0].naturalWidth;", imageElement);
        if (naturalWidth != null) {
            return naturalWidth > 0;
        } else {
            return false;
        }
    }


    //3)Проверить работу ссылки «Подробнее о сервисе»;
    @Test
    public void testInfoLink() {
        var linkElement = paySection.findElement(By.linkText("Подробнее о сервисе"));
        linkElement.click();

        String title = driver.getTitle();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "URL страницы после клика не соответствует.");

        Assert.assertEquals(title,
                "Порядок оплаты и безопасность интернет платежей",
                "Заголовок отличается от ожидаемого");

        driver.get("https://www.mts.by/");
    }

    //4)Заполнить поля и проверить работу кнопки «Продолжить»
//(проверяем только вариант «Услуги связи», номер для теста 297777777)
    @Test
    public void testSubmitCommunicationServicesPayment() {
        var phoneElement = paySection.findElement(By.id("connection-phone"));
        var sumElement = paySection.findElement(By.id("connection-sum"));
        var buttonElement = paySection.findElement(By.id("pay-connection")).findElement(By.className("button__default"));
        phoneElement.click();
        phoneElement.sendKeys("297777777");
        sumElement.click();
        sumElement.sendKeys("100");
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(buttonElement));
        continueButton.click();
        WebElement iframeElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
        WebElement titleElement = driver.findElement(By.tagName("title"));
        String title = titleElement.getAttribute("textContent");
        Assert.assertEquals(title, "BePaidWidget",
                "Заголовок фрейма отличается от ожидаемого.");

        /*
id="cc-number"
4024 0071 2387 4108
*/
        WebElement numberElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("input[formcontrolname='creditCard']")));

        numberElement.click();
        numberElement.sendKeys("4024007123874108");
/*
formcontrolname="expirationDate"
02 / 25
        */
        WebElement expirationDateElement = driver.
                findElement(By.cssSelector("input[formcontrolname='expirationDate']"));
        expirationDateElement.click();
        expirationDateElement.sendKeys("0225");

/*
formcontrolname="cvc"
123
        */
        WebElement cvcElement = driver.
                findElement(By.cssSelector("input[formcontrolname='cvc']"));
        cvcElement.click();
        cvcElement.sendKeys("123");
/*
formcontrolname="holder"
IVAN IVANOV
*/
        WebElement holderElement = driver.
                findElement(By.cssSelector("input[formcontrolname='holder']"));
        holderElement.click();
        holderElement.sendKeys("IVAN IVANOV");

        WebElement buttonPayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Оплатить')]")));

        Assert.assertTrue(buttonPayElement.isEnabled(), "кнопка 'Оплатить ...'  не активная");
    }


}

