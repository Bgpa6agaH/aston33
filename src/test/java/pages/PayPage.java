package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement paySection;

    By cookieLocator = By.id("cookie-agree");
    By payLocator = By.className("pay");
    By h2Locator = By.tagName("h2");
    By paymentSystemsListLocator = By.className("pay__partners");
    By infoLinkLocator = By.linkText("Подробнее о сервисе");

    By connectionPhoneLocator = By.id("connection-phone");
    By connectionSumLocator = By.id("connection-sum");
    By payConnectionLocator = By.id("pay-connection");
    By buttonDefaultLocator = By.className("button__default");

    By bePaidFrameLocator = By.className("bepaid-iframe");


    By buttonPaySelectLocator = By.className("select__header");
    By listPaySelectLocator = By.className("select__list");


    By CommunicationServicesLocator = By.xpath("//p[text()='Услуги связи']");

    By connectionPhoneLabelLocator = By.cssSelector("label[for='connection-phone']");

    By connectionSumLabelLocator = By.cssSelector("label[for='connection-sum']");

    By connectionEmailPlaceholderLocator = By.id("connection-email");


    By homeInternetLocator = By.xpath("//p[text()='Домашний интернет']");
    By internetPhoneLocator = By.id("internet-phone");
    By internetSumLocator = By.id("internet-sum");
    By internetEmailPlaceholderLocator = By.id("internet-email");

    By installmentPlanLocator = By.xpath("//p[text()='Рассрочка']");
    By instalmentScoreLocator = By.id("score-instalment");
    By instalmentSumLocator = By.id("instalment-sum");
    By instalmentEmailPlaceholderLocator = By.id("instalment-email");


    By arrearsLocator = By.xpath("//p[text()='Задолженность']");
    By arrearsScoreLocator = By.id("score-arrears");
    By arrearsSumLocator = By.id("arrears-sum");
    By arrearsEmailPlaceholderLocator = By.id("arrears-email");


    public PayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.paySection = wait.until(ExpectedConditions.presenceOfElementLocated(payLocator));
    }

    @Step("Обработка файлов cookie: принять")
    public void agreeCookie() {
        WebElement cookieAcceptElement = wait.until(
                ExpectedConditions.elementToBeClickable(cookieLocator)
        );
        cookieAcceptElement.click();
    }


    public WebElement getH2Element() {
        return paySection.findElement(h2Locator);
    }

    public WebElement getPayPartners() {
        return paySection.findElement(paymentSystemsListLocator);
    }

    @Step("клик на 'Подробнее о сервисе'")
    public void clickInfoLink() {
        var linkElement = paySection.findElement(infoLinkLocator);
        linkElement.click();
    }

    @Step("Ввод телефона: {number}")
    public void inputPhone(String number) {
        var phoneElement = paySection.findElement(connectionPhoneLocator);
        phoneElement.click();
        phoneElement.sendKeys(number);
    }

    @Step("Ввод суммы: {sum}")
    public void inputSum(String sum) {
        var sumElement = paySection.findElement(connectionSumLocator);
        sumElement.click();
        sumElement.sendKeys(sum);
    }

    @Step("Клик на кнопку 'Продолжить'")
    public void clickPayNextButton() {
        var buttonElement = paySection.findElement(payConnectionLocator).findElement(buttonDefaultLocator);
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(buttonElement));
        continueButton.click();
    }

    public WebElement getFrameElement() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(bePaidFrameLocator));
    }

    @Step("Клик на Accordion")
    public void clickButtonPaySelect() {
        wait.until(
                ExpectedConditions.presenceOfElementLocated(buttonPaySelectLocator));
        var buttonElement = paySection.findElement(buttonPaySelectLocator);
        buttonElement.click();
    }

    @Step("Выбрать в Accordion Услуги связи")
    public void selectListPayItemCommunicationServices() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        WebElement itemElement = listPaySelectElement.findElement(CommunicationServicesLocator);
        itemElement.click();
    }


    public String getPlaceholderConnectionPhone() {
        return paySection.findElement(connectionPhoneLocator).getAttribute("placeholder");
    }

    public String getTextConnectionPhoneLabel() {
        return paySection.findElement(connectionPhoneLabelLocator).getText();
    }

    public String getPlaceholderConnectionSum() {
        return paySection.findElement(connectionSumLocator).getAttribute("placeholder");
    }

    public String getTextConnectionSumLabel() {
        return paySection.findElement(connectionSumLabelLocator).getText();
    }

    public String getPlaceholderConnectionEmail() {
        return paySection.findElement(connectionEmailPlaceholderLocator).getAttribute("placeholder");
    }

    @Step("Выбрать в Accordion Домашний интернет")
    public void selectListPayItemHomeInternet() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        listPaySelectElement.findElement(homeInternetLocator).click();
    }

    public String getPlaceholderInternetPhone() {
        return paySection.findElement(internetPhoneLocator).getAttribute("placeholder");
    }

    public String getPlaceholderInternetSum() {
        return paySection.findElement(internetSumLocator).getAttribute("placeholder");
    }

    public String getPlaceholderInternetEmail() {
        return paySection.findElement(internetEmailPlaceholderLocator).getAttribute("placeholder");
    }

    @Step("Выбрать в Accordion Рассрочку")
    public void selectListPayItemInstallmentPlan() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        listPaySelectElement.findElement(installmentPlanLocator).click();
    }

    public String getPlaceholderInstalmentScore() {
        return paySection.findElement(instalmentScoreLocator).getAttribute("placeholder");
    }

    public String getPlaceholderInstalmentSum() {
        return paySection.findElement(instalmentSumLocator).getAttribute("placeholder");
    }

    public String getPlaceholderInstalmentEmail() {
        return paySection.findElement(instalmentEmailPlaceholderLocator).getAttribute("placeholder");
    }

    @Step("Выбрать в Accordion Задолженность")
    public void selectListPayItemArrears() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        listPaySelectElement.findElement(arrearsLocator).click();
    }

    public String getPlaceholderArrearsScore() {
        return paySection.findElement(arrearsScoreLocator).getAttribute("placeholder");
    }

    public String getPlaceholderArrearsSum() {
        return paySection.findElement(arrearsSumLocator).getAttribute("placeholder");
    }

    public String getPlaceholderArrearsEmail() {
        return paySection.findElement(arrearsEmailPlaceholderLocator).getAttribute("placeholder");
    }


}
