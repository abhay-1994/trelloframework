package activeelememt;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DefaultSug {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().click();
		List<WebElement> allDFefaultSug = driver.findElements(By.xpath("//div[@role='presentation']/ul/li"));
		for (WebElement defaultSuggestion : allDFefaultSug) {
			String suggestionTest = defaultSuggestion.getText();
			System.out.println(suggestionTest);
		}
		Select objSelect = new Select(null);
	

	}

}

