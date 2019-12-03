package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityMenu extends BasicPage {
	
	private By dashboard = By.id("sn_dashboard");
	private By shiftPlanning = By.id("sn_schedule");
	private By timeClock = By.id("sn_timeclock");
	private By leave = By.id("sn_requests");
	private By training = By.id("sn_training");
	private By staff = By.id("sn_staff");
	private By payroll = By.id("sn_payroll");
	private By reports = By.id("sn_reports");
	

	public HumanityMenu(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getDashBoard() {
		return this.driver.findElement(dashboard);
	}
	
	public WebElement getShiftPlanning() {
		return this.driver.findElement(shiftPlanning);
	}
	
	public WebElement getTimeClock() {
		return this.driver.findElement(timeClock);
	}
	
	public WebElement getLeave() {
		return this.driver.findElement(leave);
	}
	
	public WebElement getTraining() {
		return this.driver.findElement(training);
	}
	
	public WebElement getStaff() {
		return this.driver.findElement(staff);
	}
	public WebElement getPayroll() {
		return this.driver.findElement(payroll);
	}
	public WebElement getReports() {
		return this.driver.findElement(reports);
	}
	
	public void clickStaff() {
		WebElement staff = this.getStaff();
		staff.click();
	}

}
