package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPageSimple {
    private WebDriver driver;

    // Declare element selector value here
    private By countrySelector = By.id("country");
    private By stateSelector = By.id("region_id");
    private By zipInput = By.id("postcode");

    private By estimateButton = By.xpath("//span[contains(text(),'Estimate')]");
    private By flatRateRadioButton = By.id("s_method_flatrate_flatrate");
    private By updateTotalButton = By.cssSelector("button[title='Update Total']");
    private By proceedToCheckoutButton = By.cssSelector("button[title='Proceed to Checkout']");

    // Constructor with required parameter as a WebDriver instance
    public CartPageSimple(WebDriver driver) {
        this.driver = driver;
    }

    // Getter to return element on the page
    public WebElement country() {
        return driver.findElement(countrySelector);
    }

    public WebElement state() {
        return driver.findElement(stateSelector);
    }

    public WebElement zip() {
        return driver.findElement(zipInput);
    }

    public WebElement estimate() {
        return driver.findElement(estimateButton);
    }

    public WebElement flatRate() {
        return driver.findElement(flatRateRadioButton);
    }

    public WebElement updateTotal() {
        return driver.findElement(updateTotalButton);
    }

    public WebElement proceedToCheckout() {
        return driver.findElement(proceedToCheckoutButton);
    }

    // Methods to perform actions on the elements
    public void selectCountry(String country) {
        WebElement countrySelectorElement = driver.findElement(countrySelector);
        Select countryDropdown = new Select(countrySelectorElement);
        countryDropdown.selectByVisibleText(country);
    }

    public void selectStateProvince(String stateProvince) {
        WebElement stateProvinceSelectorElement = driver.findElement(stateSelector);
        Select stateProvinceDropdown = new Select(stateProvinceSelectorElement);
        stateProvinceDropdown.selectByVisibleText(stateProvince);
    }

    public void inputZip(String zip){
        WebElement zipElement = driver.findElement(zipInput);
        zipElement.sendKeys(zip);
    }

    public void clickEstimate(){
        WebElement estimateElement = driver.findElement(estimateButton);
        estimateElement.click();
    }

    public void clickFlatRate(){
        WebElement flatRateElement = driver.findElement(flatRateRadioButton);
        flatRateElement.click();
    }

    public void clickUpdateTotal(){
        WebElement updateTotalElement = driver.findElement(updateTotalButton);
        updateTotalElement.click();
    }

    public void clickOnProceedToCheckout(){
        WebElement proceedToCheckoutElement = driver.findElement(proceedToCheckoutButton);
        proceedToCheckoutElement.click();
    }
}
