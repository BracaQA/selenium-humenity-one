package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HumanityStaff extends BasicPage {
	
	private By addEmployees = By.cssSelector("button#act_primary");
	private By inputElements = By.cssSelector("._add_staff_tb tr._ns_row");
	
	//ova 3 sam ja dodala, da lepse izgleda kod dole (nemaju metode za get, nego ih pozivam sa this)
	private By nameElement = By.cssSelector("[placeholder='first name']");
	private By surnameElement = By.cssSelector("[placeholder='last name']");
	private By emailElement =  By.cssSelector("[placeholder='email@address.com']");
	
	private By saveEmployees = By.id("_as_save_multiple");
	
	//brojac do kog smo zaposlenog stigli u tabeli
	private int numberOfEmployee = 0;

	public HumanityStaff(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getEmployees() {
		return this.driver.findElement(addEmployees);
	}
	
	public WebElement getSaveEmployees() {
		return this.driver.findElement(saveEmployees);
	}
	
	public List<WebElement> getInputElements(){
		return this.driver.findElements(inputElements);
	}
	
	//njihova metoda cela
	public WebElement getInputsForRow(WebElement element, By findBy) {
		return element.findElement(findBy);
	}
	
	public void addEmployee(String name, String surname, String email) {
		//kao sto smo nabavljali pojedinacno elemente, ovde nabavimo listu
		List<WebElement> inputElements = this.getInputElements();
		
		//nabavljamo element name iz reda
		WebElement nameInput = 
				this.getInputsForRow(inputElements.get(numberOfEmployee), this.nameElement);
		
		//nabavljamo element surname iz reda
		WebElement surnameInput = 
				this.getInputsForRow(inputElements.get(numberOfEmployee), this.surnameElement);
		
		//nabavljamo element email
		WebElement emailInput =
				this.getInputsForRow(inputElements.get(numberOfEmployee), this.emailElement);
		
		
		//dodajemo podatke
		nameInput.sendKeys(name);
		surnameInput.sendKeys(surname);
		emailInput.sendKeys(email);
		
		//brojac povecamo za 1, da bi sledeci zaposlen bio unesen u sledeci red
		numberOfEmployee++;
		
	}
	
	public void clickAddEmployees() {
		WebElement employees = this.getEmployees();
		employees.click();
	}
	
	public void clickSaveEmployees() {
		WebElement saveEmployees = this.getSaveEmployees();
		saveEmployees.click();
	}
	
	
	//metoda da se proveri da li smo dodali nekog na listu
	//preko xpatha se nadje zaposleni, ali malo izmenis string u xpathu, da bi primio
	//tvoj parametar :)
	public boolean employeeAdded(String nameAndSurname) {
		
		WebElement employeeOnList =  
		this.driver.findElement(By.xpath("//a[contains(text(),'"+nameAndSurname+"')]"));
		
		return employeeOnList != null;
		//a[contains(text(),'Maya Sky')]
		 
	}
	
	

}
