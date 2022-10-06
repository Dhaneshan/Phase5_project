import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Web_Automated
{
	@Test
    public void login() {
 
        System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.lambdatest.com/";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.linkText("Login"));
        System.out.println("Clicking on the login element in the main page");
        login.click();
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        email.clear();
        System.out.println("Entering the email");
        email.sendKeys("sdhaneshan1@gmail.com");
        password.clear();
        System.out.println("entering the password");
        password.sendKeys("Dhaneshan@2022");
        System.out.println("Clicking login button");
        loginButton.click();
        String title = "Log in";
        String actualTitle = driver.getTitle();
        System.out.println("Verifying the page title has started");
        Assert.assertEquals(actualTitle,title,"Page title doesnt match");
        System.out.println("The page title has been successfully verified");
        System.out.println("User logged in successfully");
        driver.quit();
    }
}