package BuiNgocVanSon_SE172699;

import driver.driverFactory;
import model.pages.RegisterPageSimple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.Random;

public class TC05 {
    @Test
    public void testcse05() {
        // Create an instance of the ChromeDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1: Navigate to the specified URL
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on the 'My Account' link
            WebElement accountMenu = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountMenu.click();
            WebElement myAccountLink = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccountLink.click();

            // Step 3: Click 'Create an Account' link and fill New User information
            WebElement createAccountLink = driver.findElement(By.xpath("//a[@title='Create an Account']"));
            createAccountLink.click();
            RegisterPageSimple registerPage = new RegisterPageSimple(driver);
            Random random = new Random();
            String firstName = "Bui" + random.nextInt(1000);
            String middleName = "Ngoc Van" + random.nextInt(1000);
            String lastName = "Son" + random.nextInt(1000);
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
            String expectedMessage = "Thank you for registering with Main Website Store.";
            String actualMessage = registrationMessage.getText();
            AssertJUnit.assertEquals("Registration message mismatch", expectedMessage, actualMessage);

            // Step 6: Go to TV menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
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
            messageField.sendKeys("Check out wishlist cua toi ne anh em oi!");
            WebElement shareButton = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareButton.click();

            // Step 10: Check wishlist is shared
            WebElement sharedMessage = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            String expectedSharedMsg = "Your Wishlist has been shared.";
            String actualSharedMsg = sharedMessage.getText();
            AssertJUnit.assertEquals("Shared wishlist message mismatch", expectedSharedMsg, actualSharedMsg);
        } finally {
            System.out.println("Thanks for testing");
            // Close the browser
            driver.quit();
        }
    }
}
