package Marathon2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {
/*1. Launch Salesforce application https://login.salesforce.com/
2. Login with Provided Credentials
3. Click on Learn More link in Mobile Publisher  and click Confirm
4. Click Learning and Mouse hover on Learning On Trailhead
5. Select SalesForce Certification 
6. Choose Your Role as Salesforce Architect and verify the URL
7. Get the Text(Summary) of Salesforce Architect 
8. Get the List of Salesforce Architect Certifications Available
9. Click on Application Architect 
10.Get the List of Certifications available
*/
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		//Click on Learn More link in Mobile Publisher  and click Confirm
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//Click Learning and Mouse hover on Learning On Trailhead
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(10);
		dom.findElementByXPath("//span[text()='Learning']").click();
		
		WebElement trailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(trailHead).perform();
		builder.scrollToElement(trailHead).perform();
		// 6. Click on Salesforce Certifications
		WebElement sales = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();",sales);
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'cert-site_text slds-text-align--center')]")).getText());
		//Get the List of Salesforce Architect Certifications Available
		
		List<WebElement> lst = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
	    System.out.println(lst.size());
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).getText());
			} 
		//Click on Application Architect 
		
		driver.findElement(By.xpath("//div[@class='credentials-card_title']//a")).click();
		WebElement title = driver.findElement(By.xpath("//div[text()='Earn your Prerequisites']"));
		System.out.println(title.getText());
		List<WebElement> lst2 = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
	    System.out.println(lst2.size());
	    for (int j = 0; j< lst2.size(); j++) {
	    	System.out.println(lst2.get(j).getText());
			
		}
		
		
	}


}

