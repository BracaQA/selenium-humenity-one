package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityProfile extends BasicPage {

	public HumanityProfile(WebDriver driver) {
		super(driver);
	}
	
	private By avatar = By.id("tr_avatar");
	private By avatarProfile = By.cssSelector("#userm > div > a:nth-child(3)");
	private By avatarSetings = By.cssSelector("#userm > div > a:nth-child(5)");
	private By avatarAvaile = By.cssSelector("#userm > div > a:nth-child(7)");
	private By avatarSignOut = By.cssSelector("a[href='https://pajajare.humanity.com/app/logout/0/']");
	private By avatarVersion = By.id("humanityAppVersion");
	
	public WebElement getAvatar() {
		return this.driver.findElement(avatar);
	}
	
	public WebElement getAvatarProfile() {
		return this.driver.findElement(avatarProfile);
	}
	
	public WebElement getAvatarSetings() {
		return this.driver.findElement(avatarProfile);
	}
	
	public WebElement getAvatarAvaile() {
		return this.driver.findElement(avatarAvaile);
	}
	
	public WebElement getAvatarSignOut() {
		return this.driver.findElement(avatarSignOut);
	}
	
	public WebElement getAvatarVersion() {
		return this.driver.findElement(avatarVersion);
	}
	
	public void profileBaratejsh(WebElement element ) {
		element.click();
	}
	
	public void printHumanityVersion() {
		System.out.println(getAvatarVersion().getText());
	}
	
	
	
}
