package baseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Properties p;



	
	
	@BeforeClass(groups ="sanity")
	@Parameters("browser")
	public void setup(String br) throws IOException
	{
		FileReader file = new FileReader("C:\\Users\\HP\\eclipse-workspace\\WebsiteTest\\src\\test\\java\\Utilities\\config.properties");
		p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		default : System.out.println("Invalid Browser");return;
		}
		
		
		
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/login");
		
	}	
		
		
		
		
		
		
	 @AfterClass(groups={"sanity", "regression"})
	  public void close()
	  {
		
	  driver.quit();
	  
	 }
	 
	 public String captureScreen(String tname)throws IOException
	 {
		 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 
		 TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		 File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		 
		 String targetFilePath = System.getProperty("user.dir")+tname+"_"+".png";
		 File targetFile = new File(targetFilePath);
		 
		 sourceFile.renameTo(targetFile);
		 
		 return targetFilePath;
		 
	 }

}
