package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HumanityLogin extends BasicPage {

	private By secondLogin = By.id("login");
	private By secondMail = By.cssSelector("input#email");
	private By password = By.cssSelector("input#password");

	public HumanityLogin(WebDriver driver) {
		super(driver);
	}

	public WebElement waitForElement(int timeout) {
		WebElement elementLog = null;
		try {
			System.out.println("Ceka sa " + timeout + " sekundi da se pojavi element");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			elementLog = wait.until(ExpectedConditions.visibilityOfElementLocated(secondLogin));
			System.out.println("Element se pojavljuje na strani");
		} catch (Exception e) {
			System.out.println("Element se ne pojavljuje na strani");
		}
		return elementLog;
	}
	
	public WebElement getSecondMail() {
		return this.driver.findElement(secondMail);
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(password);
	}
	
	public void fillEmail(String email) {
		WebElement mail = this.getSecondMail();
		mail.clear();
		mail.sendKeys(email);
	}
	
	public void fillPassword(String password) {
		WebElement pass = this.getPassword();
		pass.clear();
		pass.sendKeys(password);
		pass.sendKeys(Keys.ENTER);
	}
	
	

}
