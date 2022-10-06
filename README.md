# TD Amazon Test Project

Testing Amazon mobile app.
Task description is to check:
How general best coding practices such as naming convections & code indentions are respected
What design pattern is selected
How automation framework has been structured
How exceptions are handled
How assertions are covered
How multi browser testing has been supported
How parallel test executions has been handled
What Reporting/Logging tools have been used

 Test steps:
Go to Amazon App
In Search Box, type Kindle
Scroll down and select 4th item in search results
Click on BuyNow
Verify it shows Order Total Amount

## Setup requirements

Java JDK 11 , Maven and optional IDE (if you want to run from there), Appium server, real Android device or an emulator


## How to start

Using Maven
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```
Test suite for parallel execution
```bash
mvn clean test -DsuiteXmlFile=testng_parallel.xml
```
Also can be started using IDE

For generating allure reports
```bash
mvn allure:serve
```

## Note
As Amazon app is not in test mode there is no possibility to inspect and get information about Sign In screen. (Because after clicking on "Buy Now" button app goes to Sign in screen).  So the flow was altered to click on "Add to Cart" button and verify order total.

