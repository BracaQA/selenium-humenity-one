package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HumanityEditStaff;
import pages.HumanityHome;
import pages.HumanityLogin;
import pages.HumanityProfile;

public class EditSettingsToEmployee extends BasicTest  {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HumanityHome humanityHome = new HumanityHome(driver);
		Thread.sleep(2000);
		
		humanityHome.clickLogIn();
		Thread.sleep(2000);

		HumanityLogin humanityLogin = new HumanityLogin(driver);
		humanityLogin.fillEmail("jiwiyad636@tmailpro.net");
		humanityLogin.fillPassword("Paja123");
	}	
		
	@Test
	public void editSettingToEmplyeeProfile () {
		
		HumanityProfile hp = new HumanityProfile(driver);
		hp.getAvatar().click();
		hp.getAvatarProfile().click();
		
		HumanityEditStaff hd = new HumanityEditStaff(driver);
		hd.editEmployeeSettings();
	}

	
	
}
