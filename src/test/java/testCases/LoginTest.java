package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;

import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass{
	
	
  @Test
  public void loginWebsite() 
  {
	  LoginPage l = new LoginPage(driver);
	  
	  l.setUserName(p.getProperty("username"));
	  l.setPassword(p.getProperty("passowrd"));
	  l.clickLogin();
	  
	  String title= driver.getTitle();
	 
	  
	  Assert.assertEquals(title, "AutomationExercises");
	  

  }
}
