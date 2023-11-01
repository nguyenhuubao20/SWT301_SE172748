package BuiNgocVanSon_SE172699;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.Set;

public class TC04 {
    @Test
    public void testcse04() {

        // Create an instance of the ChromeDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1: Navigate to the specified URL
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on the 'MOBILE' menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            // Step 3: Click on 'Add To Compare' for 2 mobiles (Sony Xperia & Iphone)
            WebElement sonyAddToCompare = driver.findElement(By.xpath("//a[@title='Sony Xperia']//following::a[text()='Add to Compare']"));
            sonyAddToCompare.click();

            WebElement iphoneAddToCompare = driver.findElement(By.xpath("//a[@title='IPhone']//following::a[text()='Add to Compare']"));
            iphoneAddToCompare.click();

            // Step 4: Click on 'COMPARE' button
            WebElement compareButton = driver.findElement(By.xpath("//button[@title='Compare']"));
            compareButton.click();

            // Step 5: Verify the pop-up window and check that the products are reflected in it
            String mainWindow = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(mainWindow)) {
                    driver.switchTo().window(handle);
                    WebElement popupHeading = driver.findElement(By.xpath("//h1[text()='Compare Products']"));
                    AssertJUnit.assertTrue( "Popup window heading is not displayed",popupHeading.isDisplayed());

                    WebElement product1 = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
                    WebElement product2 = driver.findElement(By.xpath("//a[normalize-space()='IPhone']"));
                    AssertJUnit.assertTrue("Product 1 is not displayed in the comparison window", product1.isDisplayed());
                    AssertJUnit.assertTrue("Product 2 is not displayed in the comparison window", product2.isDisplayed());

                    String actualTitle = driver.getTitle();
                    System.out.println("Title in the comparison window: ");
                    System.out.println(actualTitle);
                    System.out.println("Products in the comparison window: ");
                    System.out.println(product1.getText());
                    System.out.println(product2.getText());
                    driver.close();
                }
            }
            // Switch back to Main Page
            driver.switchTo().window(mainWindow);

            System.out.println("Thanks for testing");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
