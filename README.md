# SWT301
# Test Automation Readme

This repository contains automated test cases for the TechPanda website. The tests have been implemented using [Selenium](https://www.selenium.dev/) and [JUnit](https://junit.org/junit5/).

## Test Cases

### TC01: Verify Sorting Functionality

**Test Steps:**

1. Go to [TechPanda](http://live.techpanda.org/).
2. Verify the title of the page.
3. Click on the 'MOBILE' menu.
4. In the list of all mobiles, select 'SORT BY' dropdown as 'name'.
5. Verify that all products are sorted by name.

### TC02: Verify Product Cost Equality

**Test Steps:**

1. Go to [TechPanda](http://live.techpanda.org/).
2. Click on the 'MOBILE' menu.
3. In the list of all mobiles, read the Sony Xperia mobile.
4. Click on the Sony Xperia mobile.
5. Read the cost of Sony Xperia mobile (which is $100) from the detail page.
6. Compare the product value in the list and detail page to ensure they are equal ($100).

### TC03: Verify that you cannot add more product in cart than the product available in store

**Test Steps:**

1. Go to [TechPanda](http://live.techpanda.org/).
2. Click on the 'MOBILE' menu.
3. In the list of all mobiles, click on 'ADD TO CART' for Sony Xperia mobile.
4. Change 'QTY' value to 1000 and click 'UPDATE' button. Expected that an error is displayed: "The requested quantity for 'Sony Xperia' is not available."
5. Verify the error message.
6. Then click on 'EMPTY CART' link in the footer of the list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify the cart is empty.

### TC04: Verify that you are able to compare two products

**Test Steps:**

1. Go to [TechPanda](http://live.techpanda.org/).
2. Click on the 'MOBILE' menu.
3. In the mobile products list, click on 'Add To Compare' for 2 mobiles (Sony Xperia & Iphone).
4. Click on 'COMPARE' button. A popup window opens.
5. Verify the pop-up window and check that the products are reflected in it with the heading "COMPARE PRODUCTS" and selected products.
6. Close the Popup Windows.

### TC05: Verify you can create an account in the e-Commerce site and can share a wishlist to other people using email

**Test Steps:**

1. Go to [TechPanda](http://live.techpanda.org/).
2. Click on the 'My Account' link.
3. Click the 'Create an Account' link and fill in New User information excluding the registered Email ID.
4. Click 'Register'.
5. Verify that the Registration is done.
6. Go to the TV menu.
7. Add a product in your wishlist - use the product - LG LCD.
8. Click 'SHARE WISHLIST'.
9. On the next page, enter Email and a message, and click 'SHARE WISHLIST'.
10. Check that the wishlist is shared successfully.


## Setup

1. Install Java (JDK) - [Link to Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
2. Install Selenium WebDriver - [Link to Selenium](https://www.selenium.dev/downloads/)
3. Set up JUnit - [Link to JUnit](https://junit.org/junit5/)

## Running the Tests

1. Clone the repository: `git clone <repository_url>`
2. Navigate to the project directory.
3. Run the tests using the command `mvn test`.
4. View the test reports in the output directory.

## Contributors

- [Sontv6666](https://github.com/sontv6666)
- [Other Contributor](https://github.com/other_contributor)

Feel free to open an issue or submit a pull request for any improvements or suggestions.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
