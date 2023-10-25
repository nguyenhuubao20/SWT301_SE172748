package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02 {

    public static void main(String[] args) {

        //Launch browser
        WebDriver driver = new ChromeDriver();

        //Step 1 - Open website
        driver.get("http://live.techpanda.org/");

        //Step 2 - Click Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();

        //Step 3 - Get Sony Xperia price
        WebElement sonyXperia = driver.findElement(By.xpath("//a[text()='Sony Xperia']/following::span[@id='product-price-1']"));
        String listPrice = sonyXperia.getText();
        System.out.println("Product name from MENU page: " +listPrice);

        //Step 4 - Click Sony Xperia link
        WebElement element = driver.findElement(By.xpath("//*[@id='product-collection-image-1']"));
        element.click();

        //Step 5
        // Đọc tên và giá từ phần tử

        WebElement nameElement = driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[1]/span"));
        String name = nameElement.getText();
        System.out.println("Product name from DETAIL page: " + name);

        WebElement priceElement = driver.findElement(By.xpath("//*[@id='product-price-1']/span"));
        String detailPrice = priceElement.getText();
        System.out.println("Product price from DETAIL page : " + detailPrice);

        //Step 6 - Compare prices
        Assert.assertEquals(listPrice, detailPrice);
        if (listPrice.equals(detailPrice)) {
            System.out.println("Equal");
        } else {
            System.out.println("No Equal");
        }
        driver.quit();

    }

}