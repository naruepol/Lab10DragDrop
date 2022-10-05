import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class DandDPractice {

	@Test
	void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1440,900));
		
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	     JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("window.scrollBy(0,250)");
		
		
		WebElement btncookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
		btncookies.click();
		
		
		By drag = By.xpath("//*[@id='draggable']");
		WebElement from = driver.findElement(drag);
		
		
		By drop = By.xpath("//*[@id='droptarget']");
		WebElement to = driver.findElement(drop);
		//System.out.println("Before : "+to.getText());
		
		//validate
		assertEquals("Drag the small circle here.",to.getText());
				
		Actions act = new Actions(driver);
		
		act.dragAndDrop(from, to).build().perform();

		Thread.sleep(5000);
		
		//System.out.println("After : "+to.getText());
		
		//validate
		assertEquals("You did great!",to.getText());
		
		Thread.sleep(5000);
		driver.close();
		System.out.println(" Finish !!!");
	}

}
