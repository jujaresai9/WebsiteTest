package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.RegistrationPage;

public class RegistrationtTest extends BaseClass{
  @Test
  public void registartion() throws InterruptedException {
	  
	  
	  
	  RegistrationPage lt = new RegistrationPage(driver);
	  //lt.setname("SAI");
	  lt.setname(randomeString());
	  
	  //lt.setemail("SaiTestingDemo1@gmail.com");
	  
	  lt.setemail(randomeString()+"@gmail.com");
	  
	  lt.clickSignUp();
	  Thread.sleep(4000);
	  
	  // String password = randomeAlphanumeric();
	 // lt.setPassword(password);
	  //lt.confirmPassword(password);
	  
	  //lt.setuppassword("Test@321");
	  lt.setuppassword(randomeAlphaNumeric());
	  Thread.sleep(3000);
	  
	  lt.setfirstname("SAI");
	  lt.setlastname("Jujary");
	  //lt.clickRadiobtn();
	  
	  lt.SetCompany("Saksoft");
	  lt.setAdress("123 Address");
	  lt.setState("Andhra Pradesh");
	  lt.SetCity("Adoni");
	  lt.setZipCode("12345");
	 // lt.setNumber("9876543210");
	  
	  lt.setNumber(randomeNumber());
	  
	  
	  
	  Thread.sleep(3000);
	  
	  lt.clickCreateAccount();
	  
	  

  }
  
  public String randomeString()
  {
	  String generatedstring = RandomStringUtils.randomAlphabetic(5);
	  return generatedstring;
  }
  
  public String randomeNumber()
  {
	  String generatednumber = RandomStringUtils.randomNumeric(10);
	  return generatednumber;
  }
  
  public String randomeAlphaNumeric() 
  {
	  String generatedstring = RandomStringUtils.randomAlphabetic(5);
	  String generatednumber = RandomStringUtils.randomNumeric(3);
	  return (generatedstring+"@"+generatednumber);
  }
  
  
}
