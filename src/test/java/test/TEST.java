package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class TEST {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Launch browser
        driver = new ChromeDriver();
        // Open website
        driver.get("http://live.techpanda.org/");
    }


    @Test
    public void testSortByName() {
        // Click on the "MOBILE" menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();
        // Select SORT BY -> dropdown as name
        WebElement sortByDropdown = driver.findElement(By.cssSelector("select[title='Sort By']"));
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText("Name");
        // Verify all products are sorted by name
        WebElement productList = driver.findElement(By.className("products-grid"));
        Assert.assertTrue(isSorted(productList, "h2"), "Products are not sorted by name");
    }

    @Test
    public void testProductDetails() {
        // Click Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();
        // Get Sony Xperia price
        WebElement sonyXperia = driver.findElement(By.xpath("//a[text()='Sony Xperia']/following::span[@id='product-price-1']"));
        String listPrice = sonyXperia.getText();
        System.out.println("Product name from MENU page: " + listPrice);

        // Click Sony Xperia link
        WebElement element = driver.findElement(By.xpath("//*[@id='product-collection-image-1']"));
        element.click();

        // Get name and price from element
        WebElement nameElement = driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[1]/span"));
        String name = nameElement.getText();
        System.out.println("Product name from DETAIL page: " + name);

        WebElement priceElement = driver.findElement(By.xpath("//*[@id='product-price-1']/span"));
        String detailPrice = priceElement.getText();
        System.out.println("Product price from DETAIL page : " + detailPrice);

        // Compare prices
        Assert.assertEquals(listPrice, detailPrice);
        if (listPrice.equals(detailPrice)) {
            System.out.println("Equal");
        } else {
            System.out.println("No Equal");
        }
    }

    @Test
    public void testSonyXperiaPriceComparison() {
        // Click Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();
        // Get Sony Xperia price from MENU page
        WebElement sonyXperia = driver.findElement(By.xpath("//a[text()='Sony Xperia']/following::span[@id='product-price-1']"));
        String listPrice = sonyXperia.getText();
        System.out.println("Product name from MENU page: " + listPrice);
        // Click Sony Xperia link
        WebElement element = driver.findElement(By.xpath("//*[@id='product-collection-image-1']"));
        element.click();
        // Read name and price from the DETAIL page
        WebElement nameElement = driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[1]/span"));
        String name = nameElement.getText();
        System.out.println("Product name from DETAIL page: " + name);
        WebElement priceElement = driver.findElement(By.xpath("//*[@id='product-price-1']/span"));
        String detailPrice = priceElement.getText();
        System.out.println("Product price from DETAIL page: " + detailPrice);
        // Compare prices
        Assert.assertEquals(listPrice, detailPrice, "Prices are not equal");
    }

    @Test
    public void testShoppingCartFlow() {
        // Click Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();

        // Add to Cart for Sony Xperia mobile
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span")).click();

        // Change 'QTY' value to 1000 and click 'UPDATE' button
        WebElement qtyField = driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input"));
        qtyField.clear();
        qtyField.sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span")).click();

        // Verify the error message
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[2]/p"));
        String expectedErrorMessage = errorMessage.getText();
        System.out.println("Error message: " + expectedErrorMessage);

        // Click on EMPTY CART link in the footer of list of all mobiles
        driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]/span/span")).click();
        WebElement emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1"));
        String actualEmptyCartMessage = emptyCartMessage.getText();
        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        Assert.assertEquals(actualEmptyCartMessage, expectedEmptyCartMessage, "Failed to empty cart.");

        // Verify cart is empty
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[2]/p[2]/a")).click();
        driver.findElement(By.linkText("MOBILE")).click();
        WebElement countCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/div/a/span[3]"));
        Assert.assertFalse(countCart.isDisplayed(), "Verify cart is empty failed.");
    }


    @Test
    public void testRegistrationAndWishlist() {
        try {
            // Step 2 - Click on the 'My Account' link
            WebElement accountMenu = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountMenu.click();
            WebElement myAccountLink = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccountLink.click();

            // Step 3: Click 'Create an Account' link and fill New User information
            WebElement createAccountLink = driver.findElement(By.xpath("//a[@title='Create an Account']"));
            createAccountLink.click();
            RegisterPageSimple registerPage = new RegisterPageSimple(driver);
            Random random = new Random();
            String firstName = "User" + random.nextInt(1000);
            String middleName = "Middle" + random.nextInt(1000);
            String lastName = "Test" + random.nextInt(1000);
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
            registerPage.inputFirstName(firstName);
            registerPage.inputMiddleName(middleName);
            registerPage.inputLastName(lastName);
            registerPage.inputEmail(email);
            registerPage.inputPassword("test123");
            registerPage.inputConfirmation("test123");
            registerPage.tickIsSubscribed();

            // Step 4: Click 'Register'
            registerPage.clickRegister();

            // Step 5: Verify Registration is done
            WebElement registrationMessage = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']"));
            String message = registrationMessage.getText();
            System.out.println("Registration message: " + message);

            // Step 6: Go to TV menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));;
            tvMenu.click();

            // Step 7: Add product in your wish list - use product - LG LCD
            WebElement product = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]"));
            product.click();

            // Step 8: Click 'SHARE WISHLIST'
            WebElement shareWishlist = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareWishlist.click();

            // Step 9: Enter Email and a message and click 'SHARE WISHLIST'
            WebElement emailField = driver.findElement(By.id("email_address"));
            emailField.sendKeys("example@example.com");
            WebElement messageField = driver.findElement(By.id("message"));
            messageField.sendKeys("Check out  wishlist cua tao ne anh em oi!");
            WebElement shareButton = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareButton.click();

            // Step 10: Check wishlist is shared
            WebElement sharedMessage = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            String sharedMsg = sharedMessage.getText();
            System.out.println("Share wishlist message: " + sharedMsg);
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    private boolean isSorted(WebElement element, String tag) {
        java.util.List<WebElement> elements = element.findElements(By.tagName(tag));
        String[] arr = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            arr[i] = elements.get(i).getText();
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
