package in.redBus.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.redBus6.BaseClass.BaseClass;

public class TrainBookingPage extends BaseClass {	
	public TrainBookingPage() {
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath = "//label[text()='From']/preceding-sibling::input")
	private WebElement fromBus;
	@FindBy(xpath = "//input[@id='dest']")
	private WebElement toBus;
	@FindBy(xpath = "//span[text()='24' and contains(@class,'dkWAbH')]")
	private WebElement date;
	@FindBy(xpath = "//button[contains(text(),'SEARCH')]")
	private WebElement searchBtnBus;
	@FindBy(xpath = "//div[contains(@class,'travels lh-24 f-bold d-color')]")
	private List<WebElement> buses;
	@FindBy(xpath = "//div[contains(@class,'dp-time f-19 d-color f-bold')]")
	private WebElement depTimes;
	@FindBy(xpath = "//div[contains(@class,'bp-time f-19 d-color disp-Inline')]")
	private WebElement arrTimes;
	@FindBy(xpath = "//span[contains(@class,'f-19')]")
	private WebElement fare;	
	@FindBy(xpath = "//span[text()='Train Tickets']")
	private WebElement travelChoice;
	@FindBy(xpath = "//input[@id='src']")
	private WebElement fromTrain;
	@FindBy(xpath = "//div[text()='Chennai - All Stations']")
	private WebElement frompl;
	@FindBy(xpath = "//input[@id='dst']")
	private WebElement toTrain;	
	@FindBy(xpath = "//div[text()='Visakhapatnam']")
	private WebElement topl;	
	@FindBy(xpath = "//button[text()='search trains']")
	private WebElement searchBtnTrain;	
	@FindBy(xpath = "//span[@class='srp_train_name']")
	private WebElement trains;	
	@FindBy(xpath = "//span[@class='srp_departure_time']")
	private WebElement deptime;	
	@FindBy(xpath = "//span[@class='srp_arrival_time']")
	private WebElement arrtime;	
	@FindBy(xpath = "//div[@class='srp_timimngs_wrap srp_src_dst_stations']")
	private WebElement farerate;
	
	public WebElement getFromBus() {
		return fromBus;
	}
	public WebElement getToBus() {
		return toBus;
	}
	public WebElement getDate() {
		return date;
	}
	public WebElement getSearchBtnBus() {
		return searchBtnBus;
	}
	public List<WebElement> getBuses() {
		return buses;
	}
	public WebElement getDepTimes() {
		return depTimes;
	}
	public WebElement getArrTimes() {
		return arrTimes;
	}
	public WebElement getFare() {
		return fare;
	}
	public WebElement getTravelChoice() {
		return travelChoice;
	}
	public WebElement getFromTrain() {
		return fromTrain;
	}
	public WebElement getFrompl() {
		return frompl;
	}
	public WebElement getToTrain() {
		return toTrain;
	}
	public WebElement getTopl() {
		return topl;
	}
	public WebElement getSearchBtnTrain() {
		return searchBtnTrain;
	}
	public WebElement getTrains() {
		return trains;
	}
	public WebElement getDeptime() {
		return deptime;
	}
	public WebElement getArrtime() {
		return arrtime;
	}
	public WebElement getFarerate() {
		return farerate;
	}				
}
