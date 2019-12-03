package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HumanityHome;
import pages.HumanityLogin;
import pages.HumanityMenu;
import pages.HumanityStaff;
import pages.TitlePage;

public class LoginTest extends BasicTest {

	private String baseUrl = "https://www.humanity.com/";
	
	@Test(priority = 1)
	public void basicLogin() throws Exception {
		driver.get(baseUrl);
		// OVO JE KLJUCNO - zato tebi nije radilo :)
		driver.manage().window().maximize();
		HumanityHome humanityHome = new HumanityHome(driver);
		Thread.sleep(2000);

		humanityHome.clickLogIn();
		Thread.sleep(2000);

		HumanityLogin humanityLogin = new HumanityLogin(driver);
		
		File file = new File("nalog.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);//iz ovogcitamo
		
		for (int i = 1; i < 2; i++) {
			String mail = sheet.getRow(1).getCell(0).getStringCellValue();
			String pass = sheet.getRow(1).getCell(1).getStringCellValue();
			
			humanityLogin.fillEmail(mail);
			humanityLogin.fillPassword(pass);
		}
		
//		
//		humanityLogin.fillEmail("jiwiyad636@tmailpro.net");
//		humanityLogin.fillPassword("Paja123");
		Thread.sleep(2000);

		// ova klasa je uvedena jer drugacije ne moze da se dohvati driver i vidi title
		TitlePage titlePage = new TitlePage(driver);

		Assert.assertTrue(titlePage.getTitle().contains("Dashboard"));
		;
	}

	@Test(priority = 2)
	public void addNewEmployee() throws InterruptedException, Exception {
		
		driver.get("https://sdn1.humanity.com/app/dashboard/");
		Thread.sleep(2000);

		HumanityMenu humanityMenu = new HumanityMenu(driver);
		humanityMenu.clickStaff();
		Thread.sleep(2000);

		HumanityStaff humanityStaff = new HumanityStaff(driver);
		humanityStaff.clickAddEmployees();
		Thread.sleep(2000);
		
//		humanityStaff.addEmployee("Maya", "Sky", "maya.skyyy@hotmail.com");
//		humanityStaff.addEmployee("Pera", "Peric", "test.aht@gmail.com");
//		humanityStaff.addEmployee("Voj", "Mi", "braca.CAAAR@outlook.com");
		//ovo je kada ruchno ubacujesh
		
		File file = new File("radnici.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);//iz ovogcitamo
		
		//ova petlja ubacuje podatke iz exel dokumenta koji se 
		// nalazi ubacen u projekat
		for (int i = 1; i < 5; i++) {
			String name = sheet.getRow(i).getCell(0).getStringCellValue();
			String surname = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			
			humanityStaff.addEmployee(name, surname, email);
		}
		
		humanityStaff.clickSaveEmployees();

		driver.navigate().back();
		Thread.sleep(2000);

		Assert.assertTrue(humanityStaff.employeeAdded("Maya Sky"));
	}
}
