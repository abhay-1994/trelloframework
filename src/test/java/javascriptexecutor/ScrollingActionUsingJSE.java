package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollingActionUsingJSE {
	@Test
	public void scrollByJSE() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.wikipedia.org/");
		Actions actions = new Actions(driver);
		actions.sendKeys("India").sendKeys(Keys.ENTER).perform();
		JavascriptExecutor jSE = (JavascriptExecutor)driver;
		jSE.executeScript("window.scrollby(0,1000)");
		
				
	}

}
