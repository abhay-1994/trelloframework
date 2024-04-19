package handlingpopups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HowToHandlePopUps {
	
	
	WebDriver driver;
	@BeforeMethod
	public void preCondition() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	@Test
	public void alertWithOk() {
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		driver.switchTo().alert().accept();
	}
	@Test
	public void alertWithOkanCancel() {
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.switchTo().alert().dismiss();
	}
	@Test
	public void neglectYourHiddenDivisionPopup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/hidden?sublist=0");
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.click();
		Thread.sleep(3000);
		
	}
	@Test
	public void handleYourHiddenDivisionPopup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/hidden?sublist=0");
		driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("Demo");
		Thread.sleep(3000);

	}
	@Test
	public void notificationPopup() {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notification");
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.justdial.com/");	
	}
	public void handlingShadowRootMethod() {
		driver.get("chrome://settings/accessibility");
		WebElement shadowHost01 = driver.findElement(By.tagName("settings-ui"));
		SearchContext shadowRoot01 = shadowHost01.getShadowRoot();
		WebElement shadowHost02 = shadowRoot01.findElement(By.id("main"));
		SearchContext shadowRoot02 = shadowHost02.getShadowRoot();
		
	}
	@Test
	public void fileDownloadPopUp() throws InterruptedException, AWTException {
		driver.get("https://www.selenium.dev/downloads/");
		JavascriptExecutor jSE = (JavascriptExecutor)driver;
		jSE.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='4.18.1']")).click();
		Thread.sleep(2000);
		driver.get("chrome://downloads/");
		WebElement shadowHost01 = driver.findElement(By.tagName("downloads-manager"));
		SearchContext shadowRoot01 = shadowHost01.getShadowRoot();
		WebElement shadowHost02 = shadowRoot01.findElement(By.id("frb0"));
		SearchContext shadowRoot02 = shadowHost02.getShadowRoot();
		WebElement keepButtonTargetEle = shadowRoot02.findElement(By.cssSelector("cr-button[focus-type='save']"));
		keepButtonTargetEle.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		
		
	}
	
}
