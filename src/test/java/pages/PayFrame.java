package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PayFrame {

    WebDriver driver;
    WebDriverWait wait;


    By titleLocator = By.tagName("title");

    By creditCardLocator = By.cssSelector("input[formcontrolname='creditCard']");
    By creditCardLabelLocator = By.xpath("//input[@formcontrolname='creditCard']/following-sibling::label");

    By expirationDateLocator = By.cssSelector("input[formcontrolname='expirationDate']");
    By expirationDateLabelLocator = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");

    By cvcLocator = By.cssSelector("input[formcontrolname='cvc']");
    By cvcLabelLocator = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");

    By holderLocator = By.cssSelector("input[formcontrolname='holder']");
    By holderLabelLocator = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");

    By buttonLocator = By.xpath("//button[contains(text(), 'Оплатить')]");


    //2)Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
    //нажать кнопку «Продолжить» и в появившемся окне проверить корректность
    //отображения суммы (в том числе на кнопке),
    //<div _ngcontent-ng-c3137724728="" class="pay-description__cost">
    //  <span _ngcontent-ng-c3137724728="">100.00 BYN</span><!----><!---->
    //</div>
    By payDescriptionCostLocator = By.className("pay-description__cost");


    //номера телефона, а также надписей в незаполненных полях для ввода
    //<div _ngcontent-ng-c3137724728="" class="pay-description__text">
    //  <span _ngcontent-ng-c3137724728="">Оплата: Услуги связи Номер:375297777777</span>
    //</div>
    By payDescriptionTextLocator = By.className("pay-description__text");

    public String getTextPayDescriptionText() {

        return driver.findElement(payDescriptionTextLocator).getText();
    }

    //реквизитов карты,
    //By creditCardLocator = By.cssSelector("input[formcontrolname='creditCard']");
    public String getTextCreditCard() {
        return wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(creditCardLabelLocator)
                )
                .getText();

    }

    //By expirationDateLocator = By.cssSelector("input[formcontrolname='expirationDate']");
    public String getTextExpirationDate() {
        return driver.findElement(expirationDateLabelLocator).getText();
    }

    //By cvcLocator = By.cssSelector("input[formcontrolname='cvc']");
    public String getTextCvc() {
        return driver.findElement(cvcLabelLocator).getText();
    }

    //By holderLocator = By.cssSelector("input[formcontrolname='holder']");
    public String getTextHolder() {
        return driver.findElement(holderLabelLocator).getText();
    }

    //наличие иконок платёжных систем.
//<div _ngcontent-ng-c891095944="" class="cards-brands cards-brands__container ng-tns-c891095944-0 ng-trigger ng-trigger-brandsState ng-star-inserted">
// <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/visa-system.svg" style="">
// <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/mastercard-system.svg" style="">
// <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-star-inserted" src="assets/images/payment-icons/card-types/belkart-system.svg" style=""><!---->
// <div _ngcontent-ng-c891095944="" class="cards-brands cards-brands_random ng-tns-c891095944-0 ng-star-inserted" style="">
// <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-trigger ng-trigger-randomCardState ng-star-inserted ng-animating" src="assets/images/payment-icons/card-types/maestro-system.svg" style="">
// <img _ngcontent-ng-c891095944="" class="ng-tns-c891095944-0 ng-trigger ng-trigger-randomCardState ng-star-inserted ng-animating" src="assets/images/payment-icons/card-types/mir-system-ru.svg" style=""><!----></div><!----></div>
    By containerCardsBrandsLocator = By.cssSelector("cards-brands__container");
    By contentContainerLocator = By.className("content-container");
    By iconsContainerLocator = By.className("icons-container");


    public PayFrame(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public WebElement getTitle() {
        return driver.findElement(titleLocator);
    }


    public PayFrame inputNumber() {
        WebElement numberElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(creditCardLocator)
        );
        numberElement.click();
        numberElement.sendKeys("4024007123874108");
        return this;
    }

    public PayFrame inputExpirationDate() {
        WebElement expirationDateElement = driver.findElement(expirationDateLocator);
        expirationDateElement.click();
        expirationDateElement.sendKeys("0225");
        return this;
    }


    public PayFrame inputCvc() {
        WebElement cvcElement = driver.findElement(cvcLocator);
        cvcElement.click();
        cvcElement.sendKeys("123");
        return this;
    }


    public PayFrame inputHolder() {
        WebElement holderElement = driver.findElement(holderLocator);
        holderElement.click();
        holderElement.sendKeys("IVAN IVANOV");
        return this;
    }

    public boolean isEnabledButtonPay() {
        WebElement buttonPayElement = wait.until(
                ExpectedConditions.elementToBeClickable(buttonLocator)
        );
        return buttonPayElement.isEnabled();
    }


    public String getTextPayDescriptionCost() {

        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(payDescriptionCostLocator)
                )
                .getText();

    }


    public List<WebElement> getListIcons() {


        WebElement container = wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(contentContainerLocator))
                .findElement(iconsContainerLocator);


        List<WebElement> icons = container.findElements(By.tagName("img"));
        wait.until(
                ExpectedConditions.visibilityOf(icons.get(0))
        );
        return icons;
    }
}
