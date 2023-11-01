package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPageSimple {
    private WebDriver driver;

    // Declare element selector values here
    private By addressField = By.id("billing:street1");
    private By cityField = By.id("billing:city");
    private By stateProvinceSelector = By.id("billing:region_id");
    private By zipField = By.id("billing:postcode");
    private By countrySelector = By.id("billing:country_id");
    private By telephoneField = By.id("billing:telephone");

    private By useForShippingNoCheckbox = By.xpath("//label[@for='billing:use_for_shipping_yes']");
    private By continueButton = By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]");

    private By sameAsBillingCheckbox = By.xpath("//label[@for='shipping:same_as_billing']");

    private By paymentMethodCheckmo = By.xpath("//label[@for='p_method_checkmo']");

    private By placeOrderButton = By.xpath("//button[@title='Place Order']");

    // Constructor with required parameter as a WebDriver instance
    public CheckOutPageSimple(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements on the page
    public void inputAddress(String address) {
        WebElement addressFieldElement = driver.findElement(addressField);
        addressFieldElement.sendKeys(address);
    }

    public void inputCity(String city) {
        WebElement cityFieldElement = driver.findElement(cityField);
        cityFieldElement.sendKeys(city);
    }

    public void selectStateProvince(String stateProvince) {
        WebElement stateProvinceSelectorElement = driver.findElement(stateProvinceSelector);
        Select stateProvinceDropdown = new Select(stateProvinceSelectorElement);
        stateProvinceDropdown.selectByVisibleText(stateProvince);
    }

    public void inputZip(String zip) {
        WebElement zipFieldElement = driver.findElement(zipField);
        zipFieldElement.sendKeys(zip);
    }

    public void selectCountry(String country) {
        WebElement countrySelectorElement = driver.findElement(countrySelector);
        Select countryDropdown = new Select(countrySelectorElement);
        countryDropdown.selectByVisibleText(country);
    }

    public void inputTelephone(String telephone) {
        WebElement telephoneFieldElement = driver.findElement(telephoneField);
        telephoneFieldElement.sendKeys(telephone);
    }

    public void clickUseForShippingNo() {
        WebElement useForShippingNoCheckboxElement = driver.findElement(useForShippingNoCheckbox);
        useForShippingNoCheckboxElement.click();
    }

    public void clickContinue() {
        WebElement continueButtonElement = driver.findElement(continueButton);
        continueButtonElement.click();
    }

    public void clickSameAsBilling() {
        WebElement sameAsBillingCheckboxElement = driver.findElement(sameAsBillingCheckbox);
        sameAsBillingCheckboxElement.click();
    }

    public void clickPaymentMethodCheckmo() {
        WebElement paymentMethodCheckmoElement = driver.findElement(paymentMethodCheckmo);
        paymentMethodCheckmoElement.click();
    }

    public void clickPlaceOrder() {
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButton);
        placeOrderButtonElement.click();
    }
}
