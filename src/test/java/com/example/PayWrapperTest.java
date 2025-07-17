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
import org.testng.asserts.SoftAssert;
import pages.PayFrame;
import pages.PayPage;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/*

1) Проверить название указанного блока;
2) Проверить наличие логотипов платёжных систем;
3)Проверить работу ссылки «Подробнее о сервисе»;
4)Заполнить поля и проверить работу кнопки «Продолжить»
(проверяем только вариант «Услуги связи», номер для теста 297777777)
 */

/*
1)Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
услуги связи, домашний интернет, рассрочка, задолженность;

2)Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы
(в том числе на кнопке), номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты,
наличие иконок платёжных систем.
 */


public class PayWrapperTest {

    private WebDriver driver;
    private PayPage payPage;


    @BeforeClass
    void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        payPage = new PayPage(driver);
        payPage.agreeCookie();
    }


    @BeforeMethod
    public void setUp() {
        driver.get("https://www.mts.by/");
        payPage = new PayPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.switchTo().defaultContent();
        payPage = new PayPage(driver);
    }
    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }


//1) Проверить название указанного блока;

    @Test(priority = 1)
    public void testPayWrapperTitle() {
        WebElement h2Element = payPage.getH2Element();
        Assert.assertEquals(h2Element.getText(), "Онлайн пополнение\nбез комиссии",
                "Название блока отличается от 'Онлайн пополнение без комиссии'");
    }

    //2) Проверить наличие логотипов платёжных систем;
    @Test(priority = 2)
    public void testPayWrapperLogos() {
        WebElement paymentSystemsList = payPage.getPayPartners();
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



    @Test(priority = 3)
    public void testInfoLink() {
        payPage.clickInfoLink();
        String title = driver.getTitle();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "URL страницы после клика не соответствует.");

        Assert.assertEquals(title,
                "Порядок оплаты и безопасность интернет платежей",
                "Заголовок отличается от ожидаемого");
        driver.get("https://www.mts.by/");
        payPage = new PayPage(driver);
    }



    //4)Заполнить поля и проверить работу кнопки «Продолжить»
//(проверяем только вариант «Услуги связи», номер для теста 297777777)
    @Test(priority = 4)
    public void testSubmitCommunicationServicesPayment() {

        String number = "297777777";
        payPage.inputPhone(number);
        String sum = "100";
        payPage.inputSum(sum);
        payPage.clickPayNextButton();

        WebElement iFrameElement = payPage.getFrameElement();
        driver.switchTo().frame(iFrameElement);
        PayFrame payFrame = new PayFrame(driver);

        String title = payFrame.getTitle().getAttribute("textContent");
        Assert.assertEquals(title, "BePaidWidget",
                "Заголовок фрейма отличается от ожидаемого.");


        boolean isEnabledButtonPay = payFrame
                .inputNumber()
                .inputExpirationDate()
                .inputCvc()
                .inputHolder()
                .isEnabledButtonPay();

        Assert.assertTrue(isEnabledButtonPay, "кнопка 'Оплатить ...'  не активная");

    }


    //1)Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
//услуги связи,
    @Test(priority = 5)
    public void testTextCommunicationServicesPayment() {
        payPage.clickButtonPaySelect();
        payPage.selectListPayItemCommunicationServices();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(payPage.getPlaceholderConnectionPhone(), "Номер телефона");
        softAssert.assertEquals(payPage.getTextConnectionPhoneLabel(), "+375");
        softAssert.assertEquals(payPage.getPlaceholderConnectionSum(), "Сумма");
        softAssert.assertEquals(payPage.getTextConnectionSumLabel(), "Руб.");
        softAssert.assertEquals(payPage.getPlaceholderConnectionEmail(), "E-mail для отправки чека");
        softAssert.assertAll();

    }

//1)Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
    //домашний интернет

    @Test(priority = 6)
    public void testTextHomeInternetPayment() {
        payPage.clickButtonPaySelect();
        payPage.selectListPayItemHomeInternet();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(payPage.getPlaceholderInternetPhone(), "Номер абонента");
        softAssert.assertEquals(payPage.getPlaceholderInternetSum(), "Сумма");
        softAssert.assertEquals(payPage.getPlaceholderInternetEmail(), "E-mail для отправки чека");

        softAssert.assertAll();
    }

    //1)Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
    // рассрочка
    @Test(priority = 7)
    public void testTextInstalmentPayment() {
        payPage.clickButtonPaySelect();
        payPage.selectListPayItemInstallmentPlan();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(payPage.getPlaceholderInstalmentScore(), "Номер счета на 44");
        softAssert.assertEquals(payPage.getPlaceholderInstalmentSum(), "Сумма");
        softAssert.assertEquals(payPage.getPlaceholderInstalmentEmail(), "E-mail для отправки чека");

        softAssert.assertAll();
    }

    //1)Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
    // задолженность;
    @Test(priority = 8)
    public void testTextArrearsPayment() {
        payPage.clickButtonPaySelect();
        payPage.selectListPayItemArrears();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(payPage.getPlaceholderArrearsScore(), "Номер счета на 2073");
        softAssert.assertEquals(payPage.getPlaceholderArrearsSum(), "Сумма");
        softAssert.assertEquals(payPage.getPlaceholderArrearsEmail(), "E-mail для отправки чека");

        softAssert.assertAll();
    }

    //2)Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
    //нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы
    //(в том числе на кнопке), номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты,
    //наличие иконок платёжных систем.

    @Test(priority = 9)
    public void testTextSubmitCommunicationServicesPayment() {
        SoftAssert softAssert = new SoftAssert();
        String number = "297777777";
        payPage.inputPhone(number);
        String sum = "100";
        payPage.inputSum(sum);
        payPage.clickPayNextButton();

        WebElement iFrameElement = payPage.getFrameElement();
        driver.switchTo().frame(iFrameElement);

        PayFrame payFrame = new PayFrame(driver);

        softAssert.assertEquals(payFrame.getTextPayDescriptionCost(), sum + ".00 BYN");
        softAssert.assertEquals(payFrame.getTextPayDescriptionText(), "Оплата: Услуги связи Номер:375" + number);

        softAssert.assertEquals(payFrame.getTextCreditCard(), "Номер карты");
        softAssert.assertEquals(payFrame.getTextExpirationDate(), "Срок действия");
        softAssert.assertEquals(payFrame.getTextCvc(), "CVC");
        softAssert.assertEquals(payFrame.getTextHolder(), "Имя и фамилия на карте");

        softAssert.assertAll();
    }
    @Test(priority = 10)
    public void testIconVisibilitySubmitCommunicationServicesPayment() {
        SoftAssert softAssert = new SoftAssert();
        String number = "297777777";
        payPage.inputPhone(number);
        String sum = "100";
        payPage.inputSum(sum);
        payPage.clickPayNextButton();

        WebElement iFrameElement = payPage.getFrameElement();
        driver.switchTo().frame(iFrameElement);
        PayFrame payFrame = new PayFrame(driver);

        List<WebElement> icons = payFrame.getListIcons();

        for (WebElement icon : icons) {

            String style = icon.getAttribute("style");

            softAssert.assertTrue(icon.isDisplayed() || Objects.requireNonNull(style).contains("opacity: 0") , "Иконка не видна: " + icon.getAttribute("src"));
        }
        softAssert.assertAll();
    }

}

