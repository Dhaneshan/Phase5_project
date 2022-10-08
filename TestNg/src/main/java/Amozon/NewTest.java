package Amozon;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	public String url = "https://www.amazon.in/";
	public WebDriver chromedriver;
	public String drivepath = "F:\\chromedriver_win32/chromedriver.exe";

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforetestcase() {
		System.setProperty("webdriver.chrome.driver", drivepath);
		chromedriver = new ChromeDriver();
		chromedriver.get(url);
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Chrome web Browser is started SucccessFully");
	}

	@Test(priority = 1)
	public void LoginWithAmazonAccont() {
		System.out.println(
				"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Login the amazon website the email and password");
		chromedriver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		chromedriver.findElement(By.id("ap_email")).sendKeys("6382093841");
		chromedriver.findElement(By.id("continue")).click();
		chromedriver.findElement(By.id("ap_password")).sendKeys("Dhaneshan@2001");
		chromedriver.findElement(By.id("signInSubmit")).click();
		System.out.println("Login SuccessFull");
		System.out.println("Checking amazon webpage title for security purpose whether we login correctly or not");
		String title = chromedriver.getTitle();
		String GivenTitle = "Amazon Sign In";
		Assert.assertEquals(GivenTitle, title);
		System.out.println("Checking the webpage title successfull");
		chromedriver.findElement(By.id("twotabsearchtextbox")).sendKeys("logitech keyboard and mouse combo");
		chromedriver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Search the required product is successfull");
		chromedriver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/a[1]/div[1]/img[1]"))
				.click();
		chromedriver.get(
				"https://www.amazon.in/Logitech-MK240-NANO-Mouse-Keyboard/dp/B01N4EV2TL/ref=sr_1_4?keywords=logitech%2Bkeyboard%2Band%2Bmouse%2Bcombo&qid=1665240125&qu=eyJxc2MiOiI0LjI2IiwicXNhIjoiMy41NyIsInFzcCI6IjIuNzUifQ%3D%3D&sprefix=tlogitec%2Caps%2C236&sr=8-4&th=1");
		System.out.println("New Webpage title test whether enter the correct webpage or not");
		String logitechurl = "Amazon.in: Buy Logitech MK240 Nano Wireless Keyboard and Mouse Combo,12 Function Keys 2.4GHz Wireless, 1000DPI,Spill-Resistant Design, PC/Mac-Black/Chartreuse Yellow Online at Low Prices in India | Logitech Reviews & Ratings";
		Assert.assertEquals(logitechurl, chromedriver.getTitle(), "Login Failed for logitech website");
		chromedriver.findElement(By.xpath(
				"//body[1]/div[2]/div[2]/div[5]/div[4]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[33]/div[1]/span[1]/span[1]/span[1]"))
				.click();
		System.out.println("Add the required product to the amazon cart is successfull");

	}

	@Test(priority = 2)
	public void Register_with_NewCustomer() {
		chromedriver.get(
				"https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=YX4Y0ZHF1S4D1VT357VQ&openid.assoc_handle=inflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=C&prepopulatedLoginId=&failedSignInCount=0&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&mobileBrowserWeblabTreatment=C");
		chromedriver.findElement(By.cssSelector("#ap_customer_name")).sendKeys("Dhaneshan");
		chromedriver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("7502945264");
		chromedriver.findElement(By.cssSelector("#ap_email")).sendKeys("sdhaneshan6@gmail.com");
		chromedriver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/input[1]"))
				.sendKeys("Dhaneshan@123");
		chromedriver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[7]/span[1]/span[1]/input[1]"))
				.click();
		System.out.println("Registertion with new login information are successfull");
	}

	@AfterTest
	public void AfterTestcase() {
		chromedriver.close();
		chromedriver.quit();
		System.out.println("Logout the chrome web browser is successfull");
	}
}
