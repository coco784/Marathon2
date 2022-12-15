package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.xpath("(//input[@class='db'])[3]")).click();
		driver.findElement(By.xpath("//table//tr[1]/td[2]")).click();
		driver.findElement(By.xpath("//table//tr[5]/td[3]")).click();
        */
		WebElement from = driver.findElement(By.xpath("//input[@id='src']"));
		from.sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@data-id='123']")).click();
		from.sendKeys(Keys.TAB);
		WebElement to = driver.findElement(By.id("dest"));
		to.sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@data-id='122']")).click();
		to.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//table//tr//td[@class='current day']")).click();
		
		driver.findElement(By.id("search_btn")).click();
		String noofbus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println(noofbus);
		/*Choose SLEEPER in the left menu 
		Print the name of the second resulting bus 
		 Click the VIEW SEATS of that bus
		 Take screenshot and close browser*/
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		String busname = driver.findElement(By.xpath("(//div[contains(@class,'travels lh-24')])[2]")).getText();
		System.out.println(busname);
		driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
        //Create physicalFile
        File dest=new File("./snaps/screenshort.png");
        //copy the source to destination
        FileUtils.copyFile(source, dest);

}
         
         
		
	
	
	}


