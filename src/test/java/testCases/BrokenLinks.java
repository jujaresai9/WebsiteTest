package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/* 
 * 1. Link href ="http://www.deadlinkcity.com/"
 * 
 * 2. http://www.deadlinkcity.com/ ----> server------> Status Code
 * 
 * 3. status code >=400 broken link
 *  Status code<400 not a broken link
 * 
 */

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		
		System.out.println(links.size());
		
		int	noOfBrokenlinks = 0;
		
		for(WebElement linkElement:links)
		{
			String hrefattValue = linkElement.getAttribute("href");
			
			if(hrefattValue==null || hrefattValue.isEmpty())
			{
				System.out.println("href attribute is null or empty, so not possible to check");
				continue;
			}
		
		try
		{
			
		
		URL linkURL = new URL(hrefattValue);// convert string to url
		 
		HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();// open connection to the server

		conn.connect(); // connect to server and sent request the server
		
		if(conn.getResponseCode()>=400)
		{
			System.out.println(hrefattValue +"---->  Broken Link");
			noOfBrokenlinks++;
		}
		
		else
		{
			System.out.println(hrefattValue  +  "-------->  Not a boken link");
		}
	}
		catch(Exception e) {
			
			
		}
		System.out.println("Number of broken links:"+ noOfBrokenlinks);
}}
	
}