package in.redBus6.StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import in.redBus.ObjectRepository.TrainBookingPage;
import in.redBus6.BaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BusBooking6 extends BaseClass {
	
	public static BaseClass base = new BaseClass();

	TrainBookingPage trainBookingPage = new TrainBookingPage();
	public static String fromPlace;
	public static String toPlace;
	public static WebDriverWait wait;
	
	@Given("Launch the browser and appilication {string}")
	public void launch_the_browser_and_appilication(String url) throws IOException {
		File f = new File("C:\\Users\\PRAVEEN\\eclipse-workspace-latest\\RedBus6\\src\\test\\resources\\Utilities.property");
		FileInputStream fi = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fi);
		String file = prop.getProperty("file");
		String url1 = prop.getProperty("url");
		
		FileOutputStream fo = new FileOutputStream(f);
		prop.setProperty("url", "https:www.redbus.in");
		prop.save(fo, "Updated URL");
		System.out.println(file+" and "+url1);
		base.launchApplication(url1);
		//base.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(240));
	}
	@When("User enters the value in from place {string}")
	public void user_enters_the_value_in_from_place(String fromPlace) throws InterruptedException {
		//WebElement fromBus = driver.findElement(By.xpath("//label[text()='From']/preceding-sibling::input"));
		base.waits();
		base.inputKeys(trainBookingPage.getFromBus(), fromPlace);
		WebElement frompl = driver.findElement(By.xpath("//text[text()='"+fromPlace+"']/parent::div[contains(@class,'grvhsy')]"));
		base.button(frompl);		
	}

	@When("User enters the value in to place {string}")
	public void user_enters_the_value_in_to_place(String toPlace) {
		//WebElement toBus = driver.findElement(By.xpath("//input[@id='dest']"));					
		base.inputKeys(toPlace, trainBookingPage.getToBus());				
		WebElement topl = driver.findElement(By.xpath("//text[text()='"+toPlace+"']/parent::div[contains(@class,'grvhsy')]"));
		base.button(topl);
	}
	@When("User selects a data  in the Date DropDown")
	public void user_selects_a_data_in_the_Date_DropDown() {
		//WebElement date = driver.findElement(By.xpath("//span[text()='24' and contains(@class,'dkWAbH')]"));
		base.button(trainBookingPage.getDate());		
	}
	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		//WebElement searchBtnBus = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
		base.button(trainBookingPage.getSearchBtnBus());	
	}
	@Then("Validate the bus displayed in the UI")
	public void validate_the_bus_displayed_in_the_UI() {
		List<WebElement> buses = driver.findElements(By.xpath("//div[contains(@class,'travels lh-24 f-bold d-color')]"));
		List<WebElement> depTimes = driver.findElements(By.xpath("//div[contains(@class,'dp-time f-19 d-color f-bold')]"));		
		List<WebElement> arrTimes = driver.findElements(By.xpath("//div[contains(@class,'bp-time f-19 d-color disp-Inline')]"));
		List<WebElement> fare = driver.findElements(By.xpath("//span[contains(@class,'f-19')]"));
		int size = trainBookingPage.getBuses().size(); 
		for(int i=0; i<size;i++) {
			//System.out.println(buses.size());
			if(i==buses.size()-1) {
				//System.out.println(buses.size());
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true)", buses.get(i));
				buses = driver.findElements(By.xpath("//div[contains(@class,'travels lh-24 f-bold d-color')]"));
				//trainBookingPage.getBuses();
				depTimes = driver.findElements(By.xpath("//div[contains(@class,'dp-time f-19 d-color f-bold')]"));
				//trainBookingPage.getDepTimes();
				arrTimes = driver.findElements(By.xpath("//div[contains(@class,'bp-time f-19 d-color disp-Inline')]"));
				//trainBookingPage.getArrTimes();
				fare = driver.findElements(By.xpath("//span[contains(@class,'f-19')]"));
				//trainBookingPage.getFare();
				size = buses.size();
			}
			else {
				//System.out.println(size);
				String bus = buses.get(i).getText();
				//System.out.println(bus);
				String depTime = depTimes.get(i).getText();
				String arrTime = arrTimes.get(i).getText();
				String eachFare = fare.get(i).getText();
				System.out.println(bus+" "+depTime+" "+arrTime+" "+eachFare);
			}										
		}
	}

}
