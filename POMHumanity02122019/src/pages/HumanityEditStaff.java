package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityEditStaff extends BasicPage {

	public HumanityEditStaff(WebDriver driver) {
		super(driver);
	}
	
	private By editDetails = By.cssSelector("#_cd_staff > div.right > div.EmployeeTop > a:nth-child(5)");
	private By editPictureBtn = By.id("fileupload");
	private By editNickName = By.id("nick_name");
	private By saveEditStaff = By.id("act_primary");
	
	public WebElement getEditDetails() {
		return this.driver.findElement(editDetails);
	}
	
	public WebElement getEditPictureBtn() {
		return this.driver.findElement(editPictureBtn);
	}
	
	public WebElement getEditNickName() {
		return this.driver.findElement(editNickName);
	}
	
	public WebElement getSaveEditStaff() {
		return this.driver.findElement(saveEditStaff);
	}
	
	public void editEmployeeSettings () {
		this.getEditDetails().click();
		this.getEditPictureBtn().sendKeys(new File("picture\\ponan.jpg").getAbsolutePath());
		this.getEditNickName().sendKeys("Konan Barbajijn");
		this.getSaveEditStaff().click();
	}
	
}
