package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityHome extends BasicPage {
	
	private By aboutUs = By.cssSelector("a[href='#']");
	private By login = By.cssSelector("a[href='https://www.humanity.com/app']");
	private By freeTrial = By.cssSelector("a.button.pale");
	private By fullName = By.cssSelector("fullname");
	private By workEmail = By.cssSelector("workemail");
	private By startFreeTrial = By.id("free-trial-link-01");

	public HumanityHome(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getAboutUs() {
		return this.driver.findElement(aboutUs);
	}
	
	public WebElement getLogin() {
		return this.driver.findElement(login);
	}
	
	public WebElement getFreeTrial() {
		return this.driver.findElement(freeTrial);
	}
	
	public WebElement getFullName() {
		return this.driver.findElement(fullName);
	}
	
	public WebElement getWorkMail() {
		return this.driver.findElement(workEmail);
	}
	
	public WebElement getStartFreeTrial() {
		return this.driver.findElement(startFreeTrial);
	}
	
	public void fillFullName(String name, String surname) {
		WebElement nameAndSurname = this.getFullName();
		nameAndSurname.sendKeys(name + " "+ surname);
	}
	
	public void fillWorkMail(String mail) {
		WebElement email = this.getWorkMail();
		email.sendKeys(mail);
	}
	
	public void clickLogIn() {
		WebElement login = this.getLogin();
		login.click();
	}

}
