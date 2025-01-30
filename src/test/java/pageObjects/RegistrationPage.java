package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
		
		@FindBy(name="name")
		WebElement name;
		
		@FindBy(xpath ="//input[@data-qa='signup-email']")
		WebElement signupemail;
		
		@FindBy(xpath ="//button[text()='Signup']")
		WebElement signup;
		
		@FindBy(xpath ="//input[@type='radio']")
		WebElement radio;
		
		@FindBy(id="password")
		WebElement signuppassword;
		
		@FindBy(id="first_name")
		WebElement firstName;
		
		@FindBy(id="last_name")
		WebElement lastName;
		
		@FindBy(id="company")
		WebElement company;
		
		@FindBy(id="address1")
		WebElement address;
		
		@FindBy(id="state")
		WebElement state;
		
		@FindBy(id="city")
		WebElement city;
		
		@FindBy(id="zipcode")
		WebElement zipcode;
		
		@FindBy(id="mobile_number")
		WebElement number;
		
		@FindBy(xpath="//button[text()='Create Account']")
		WebElement createaccount;
		
		
		public void setname(String names)
		{
			name.sendKeys(names);
		}

		public void setemail(String emailid)
		{
			signupemail.sendKeys(emailid);
		}
		
		public void clickRadiobtn()
		{
			radio.click();
		}
		
		public void setuppassword(String password)
		{
			signuppassword.sendKeys(password);
		}
		
		public void setfirstname(String fname)
		{
			firstName.sendKeys(fname);
		}
		
		public void setlastname(String lname)
		{
			lastName.sendKeys(lname);
		}
		
		public void SetCompany(String companys)
		{
			company.sendKeys(companys);
		}
		
		public void setAdress(String address1)
		{
			address.sendKeys(address1);
		}
		
		public void setState(String State)
		{
			state.sendKeys(State);
		}
		
		public void SetCity(String City)
		{
			city.sendKeys(City);
		}
		
		public void setZipCode(String Zipcode)
		{
			zipcode.sendKeys(Zipcode);
		}
		
		public void setNumber(String Number)
		{
			number.sendKeys(Number);
		}
		
		public void clickCreateAccount()
		{
			createaccount.click();
		}
		
		public void clickSignUp()
		{
			signup.click();
		}
	}


