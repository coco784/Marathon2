package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministrationCertificate {
    @Test
	public void runaAdministrationCertificate() throws IOException {
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://login.salesforce.com/");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	 driver.findElement(By.id("password")).sendKeys("Testleaf$321");
	 driver.findElement(By.id("Login")).click();
	 driver.findElement(By.xpath("//button[@title='Learn More']")).click();
	 Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	    Shadow dom = new Shadow(driver);
	    dom.findElementByXPath("//span[text()='Learning']").click();
	    WebElement trailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(trailHead).perform();
		builder.scrollToElement(trailHead).perform();
		// Click on Salesforce Certifications
		WebElement sales = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();",sales);
		
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		//7. Navigate to Certification - Administrator Overview window
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>lstWindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstWindow1.get(1));
		List<WebElement> admin = driver.findElements(By.xpath("//div[@class='credentials-card_title']//a"));
		System.out.println(admin.size());
		for (int i = 0; i <admin.size(); i++) {
			System.out.println(admin.get(i).getText());
		}
		WebElement scroll = driver.findElement(By.xpath("//h1[text()='Earn your Credential']"));
		builder.scrollToElement(scroll).perform();
		File source = driver.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./screenshort/snap1.png");
		 FileUtils.copyFile(source, dest);

		
		}

}
