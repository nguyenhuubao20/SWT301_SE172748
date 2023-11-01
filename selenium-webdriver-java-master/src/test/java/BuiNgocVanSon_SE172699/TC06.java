package BuiNgocVanSon_SE172699;


import driver.driverFactory;
import model.pages.CartPageSimple;
import model.pages.CheckOutPageSimple;
import model.pages.LoginPageSimple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Random;

    public class TC06 {
        @Test
        public void testcse06() {
            // Create an instance of the ChromeDriver
            WebDriver driver = driverFactory.getChromeDriver();

            try {
                // Step 1: Navigate to the specified URL
                driver.get("http://live.techpanda.org/");
                WebElement accountMenu = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
                accountMenu.click();
                WebElement myAccountLink = driver.findElement(By.xpath("//a[@title='Log In']"));
                myAccountLink.click();

           // Step 2: Click on the 'My Account' link and log in
                LoginPageSimple loginPage = new LoginPageSimple(driver);
                loginPage.inputUsername("sontv@123gmail.com");
                loginPage.inputPassword("123456");
                loginPage.clickOnLoginBtn();

                // Step 3: Click on MY WISHLIST link
                WebElement myWishlistLink = driver.findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']"));
                myWishlistLink.click();
                WebElement addCart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
                addCart.click();
             // Step 4: Click ADD TO CART link
                CartPageSimple cartPage = new CartPageSimple(driver);

          // Step 5: Enter general shipping details for the shipping cost estimate

                cartPage.selectCountry("Canada");
                cartPage.selectStateProvince("Quebec");
                cartPage.inputZip("your_zip");
                // Step 6: Click Estimate
                cartPage.clickEstimate();

            // Step 7: Verify Shipping cost generated


               // Step 8: Select Shipping Cost, Update Total
                cartPage.clickFlatRate();
                cartPage.clickUpdateTotal();

// Step 9: Verify shipping cost is added to total


// Step 10: Click "Proceed to Checkout"
                cartPage.clickOnProceedToCheckout();

// Step 11: Enter Billing Information, and click Continue
                CheckOutPageSimple checkOutPage = new CheckOutPageSimple(driver);
                checkOutPage.inputAddress("your_billing_info");
                checkOutPage.clickContinue();

// Step 12a: Enter Shipping Information, and click Continue
                checkOutPage.inputAddress("your_shipping_info");
                checkOutPage.selectCountry("Canada");
                checkOutPage.inputCity("Vietnam");
                checkOutPage.selectStateProvince("Quebec");
                checkOutPage.inputTelephone("123");



// Step 13: In Shipping Method, Click Continue
                checkOutPage.clickContinue();




// Step 14: In Payment Information select 'Check/Money Order' radio button. Click Continue
                checkOutPage.clickPaymentMethodCheckmo();
                checkOutPage.clickContinue();

// Step 15: Click 'PLACE ORDER' button
                checkOutPage.clickPlaceOrder();



                System.out.println("Thanks for testing");
// Close the browser
                driver.quit();


            } finally {
                System.out.println("Thanks for testing");
                // Close the browser
                driver.quit();
            }
        }
    }

