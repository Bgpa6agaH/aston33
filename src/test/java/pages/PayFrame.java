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

    By payDescriptionCostLocator = By.className("pay-description__cost");
    By payDescriptionTextLocator = By.className("pay-description__text");

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

    public String getTextPayDescriptionText() {

        return driver.findElement(payDescriptionTextLocator).getText();
    }

    public String getTextCreditCard() {
        return wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(creditCardLabelLocator)
                )
                .getText();

    }

    public String getTextExpirationDate() {
        return driver.findElement(expirationDateLabelLocator).getText();
    }

    public String getTextCvc() {
        return driver.findElement(cvcLabelLocator).getText();
    }

    public String getTextHolder() {
        return driver.findElement(holderLabelLocator).getText();
    }
}
