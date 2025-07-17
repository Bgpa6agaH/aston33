package pages;

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


    //услуги связи,
    By CommunicationServicesLocator = By.xpath("//p[text()='Услуги связи']");

    //+<input class="phone" id="connection-phone" type="text" placeholder="Номер телефона" required="" maxlength="13" autocomplete="off">
    //<label for="connection-phone">+375</label>
    By connectionPhoneLabelLocator = By.cssSelector("label[for='connection-phone']");

    //+<input class="total_rub" id="connection-sum" type="text" placeholder="Сумма" required="">

    //<label for="connection-sum">Руб.</label>
    By connectionSumLabelLocator = By.cssSelector("label[for='connection-sum']");

    //<input class="email" id="connection-email" type="text" placeholder="E-mail для отправки чека">
    By connectionEmailPlaceholderLocator = By.id("connection-email");

    // домашний интернет,
    By homeInternetLocator = By.xpath("//p[text()='Домашний интернет']");
    //<input class="phone" id="internet-phone" type="text" placeholder="Номер абонента" required="" maxlength="13" autocomplete="off">
    By internetPhoneLocator = By.id("internet-phone");
    //<input class="total_rub" id="internet-sum" type="text" placeholder="Сумма" required="">
    By internetSumLocator = By.id("internet-sum");
    //<input class="email" id="internet-email" type="text" placeholder="E-mail для отправки чека">
    By internetEmailPlaceholderLocator = By.id("internet-email");

    // рассрочка,
    By installmentPlanLocator = By.xpath("//p[text()='Рассрочка']");
    //<input class="score" id="score-instalment" type="text" placeholder="Номер счета на 44" data-mask="account-num-instalment" required="">
    By instalmentScoreLocator = By.id("score-instalment");
    //<input class="total_rub" id="instalment-sum" type="text" placeholder="Сумма" required="">
    By instalmentSumLocator = By.id("instalment-sum");
    //<input class="email" id="instalment-email" type="text" placeholder="E-mail для отправки чека">
    By instalmentEmailPlaceholderLocator = By.id("instalment-email");

    // задолженность
    By arrearsLocator = By.xpath("//p[text()='Задолженность']");
    //<input class="score" id="score-arrears" type="text" placeholder="Номер счета на 2073" data-mask="account-num-arrears" required="">
    By arrearsScoreLocator = By.id("score-arrears");
    //<input class="total_rub" id="arrears-sum" type="text" placeholder="Сумма" required="">
    By arrearsSumLocator = By.id("arrears-sum");
    //<input class="email" id="arrears-email" type="text" placeholder="E-mail для отправки чека">
    By arrearsEmailPlaceholderLocator = By.id("arrears-email");


    public PayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.paySection = wait.until(ExpectedConditions.presenceOfElementLocated(payLocator));
    }

    public void agreeCookie() {
        WebElement cookieAcceptElement = wait.until(
                ExpectedConditions.elementToBeClickable(cookieLocator)
        );
        cookieAcceptElement.click();
    }

    public WebElement getPaySection() {
        return paySection;
    }

    public WebElement getH2Element() {
        return paySection.findElement(h2Locator);
    }

    public WebElement getPayPartners() {
        return paySection.findElement(paymentSystemsListLocator);
    }


    public void clickInfoLink() {
        var linkElement = paySection.findElement(infoLinkLocator);
        linkElement.click();
    }

    public void inputPhone(String number) {
        var phoneElement = paySection.findElement(connectionPhoneLocator);
        phoneElement.click();
        phoneElement.sendKeys(number);
    }


    public void inputSum(String sum) {
        var sumElement = paySection.findElement(connectionSumLocator);
        sumElement.click();
        sumElement.sendKeys(sum);
    }

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

    public void clickButtonPaySelect() {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(buttonPaySelectLocator));
        var buttonElement = paySection.findElement(buttonPaySelectLocator);
        buttonElement.click();
    }

    public void selectListPayItemCommunicationServices() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        WebElement itemElement = listPaySelectElement.findElement(CommunicationServicesLocator);
        itemElement.click();
    }


    //+<input class="phone" id="connection-phone" type="text" placeholder="Номер телефона" required="" maxlength="13" autocomplete="off">
    public String getPlaceholderConnectionPhone() {
        return paySection.findElement(connectionPhoneLocator).getAttribute("placeholder");
    }

    //<label for="connection-phone">+375</label>
    public String getTextConnectionPhoneLabel() {
        return paySection.findElement(connectionPhoneLabelLocator).getText();
    }

    //+<input class="total_rub" id="connection-sum" type="text" placeholder="Сумма" required="">
    public String getPlaceholderConnectionSum() {
        return paySection.findElement(connectionSumLocator).getAttribute("placeholder");
    }

    //<label for="connection-sum">Руб.</label>
    public String getTextConnectionSumLabel() {
        return paySection.findElement(connectionSumLabelLocator).getText();
    }

    //<input class="email" id="connection-email" type="text" placeholder="E-mail для отправки чека">
    public String getPlaceholderConnectionEmail() {
        return paySection.findElement(connectionEmailPlaceholderLocator).getAttribute("placeholder");
    }


    // домашний интернет,
    //By HomeInternetLocator = By.xpath("//p[text()='Домашний интернет']");
    public void selectListPayItemHomeInternet() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        listPaySelectElement.findElement(homeInternetLocator).click();
    }

    //<input class="phone" id="internet-phone" type="text" placeholder="Номер абонента" required="" maxlength="13" autocomplete="off">
    //By internetPhoneLocator = By.id("internet-phone");
    public String getPlaceholderInternetPhone() {
        return paySection.findElement(internetPhoneLocator).getAttribute("placeholder");
    }

    //<input class="total_rub" id="internet-sum" type="text" placeholder="Сумма" required="">
    //By internetSumLocator = By.id("internet-sum");
    public String getPlaceholderInternetSum() {
        return paySection.findElement(internetSumLocator).getAttribute("placeholder");
    }

    //<input class="email" id="internet-email" type="text" placeholder="E-mail для отправки чека">
    //By internetEmailPlaceholderLocator = By.id("internet-email");
    public String getPlaceholderInternetEmail() {
        return paySection.findElement(internetEmailPlaceholderLocator).getAttribute("placeholder");
    }

    // рассрочка,
    public void selectListPayItemInstallmentPlan() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        listPaySelectElement.findElement(installmentPlanLocator).click();
    }

    //<input class="score" id="score-instalment" type="text" placeholder="Номер счета на 44" data-mask="account-num-instalment" required="">
    public String getPlaceholderInstalmentScore() {
        return paySection.findElement(instalmentScoreLocator).getAttribute("placeholder");
    }

    //<input class="total_rub" id="instalment-sum" type="text" placeholder="Сумма" required="">
    public String getPlaceholderInstalmentSum() {
        return paySection.findElement(instalmentSumLocator).getAttribute("placeholder");
    }

    //<input class="email" id="instalment-email" type="text" placeholder="E-mail для отправки чека">
    public String getPlaceholderInstalmentEmail() {
        return paySection.findElement(instalmentEmailPlaceholderLocator).getAttribute("placeholder");
    }


    // задолженность
    public void selectListPayItemArrears() {
        WebElement listPaySelectElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(listPaySelectLocator)
        );
        listPaySelectElement.findElement(arrearsLocator).click();
    }

    //<input class="score" id="score-arrears" type="text" placeholder="Номер счета на 2073" data-mask="account-num-arrears" required="">
    public String getPlaceholderArrearsScore() {
        return paySection.findElement(arrearsScoreLocator).getAttribute("placeholder");
    }

    //<input class="total_rub" id="arrears-sum" type="text" placeholder="Сумма" required="">
    public String getPlaceholderArrearsSum() {
        return paySection.findElement(arrearsSumLocator).getAttribute("placeholder");
    }

    //<input class="email" id="arrears-email" type="text" placeholder="E-mail для отправки чека">
    public String getPlaceholderArrearsEmail() {
        return paySection.findElement(arrearsEmailPlaceholderLocator).getAttribute("placeholder");
    }


}
