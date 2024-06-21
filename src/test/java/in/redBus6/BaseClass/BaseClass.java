package in.redBus6.BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements IBaseClass{
	
	public static WebDriver driver;
	public static Actions action;
	public static Select select;

	@Override
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("disable-popups");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);		
//		driver.get(url);
		action=new Actions(driver);
	}
//	public void get(String url) {
//		driver.get(url);	
//	}
	
	public void launchApplication(String url) {
		driver.get(url);
	}
	@Override
	public void browserClose() {
		driver.close();	
	}
	@Override
	public void inputKeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	@Override
	public void button(WebElement ele) {
		ele.click();	

	}
	@Override
	public boolean displayed(WebElement ele) {
		boolean display=ele.isDisplayed();
		return display;
	}
	@Override
	public boolean selected(WebElement ele) {
		boolean selected=ele.isSelected();
		return selected;
	}
	@Override
	public boolean enabled(WebElement ele) {
		boolean enabled=ele.isEnabled();
		return enabled;
	}
	@Override
	public void moveForward() {

		driver.navigate().forward();
	}
	@Override
	public void moveBackward() {
		driver.navigate().back();
	}
	@Override
	public String returnText(WebElement ele) {

		String text=ele.getText();
		return text;
	}
	@Override
	public String returnAttribute(WebElement ele, String attribute) {

		String attribute2=ele.getAttribute(attribute);
		return attribute2;
	}
	@Override
	public String returnCssValue(WebElement ele, String cssName) {
		String cssvalue=ele.getCssValue(cssName);
		return cssvalue;
	}
	@Override
	public void valueSelect(WebElement ele, String value) {
		select =new Select(ele);
		select.selectByValue(value);      
	}
	@Override
	public void indexSelect(WebElement ele, int i) {
		select =new Select(ele);
		select.deselectByIndex(i);
	}
	@Override
	public List<WebElement> returnOptions(WebElement ele) {

		select =new Select(ele);
		List<WebElement> options=select.getOptions();
		return options;
	}
	@Override
	public void parentWindow() {

		String parentWindow=driver.getWindowHandle();
		driver.switchTo().window(parentWindow);
	}
	@Override
	public void childWindow() {
		String parentWindow=driver.getWindowHandle();
		Set<String> childWindow=driver.getWindowHandles();
		for(String eachChildWindow:childWindow) {
			if(!parentWindow.equals(eachChildWindow)) {
				driver.switchTo().window(eachChildWindow);
			}
		}	
	}
	@Override
	public void inputkeys(Alert a, String value) {
		Alert alert=driver.switchTo().alert();
		if(value.equals("ok")) {
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	@Override
	public void screenshot(String imageName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File des =new File("C:\\Users\\PRAVEEN\\eclipse-workspace-latest\\RedBus5\\target\\"+imageName+".png");
		try {
			FileUtils.copyFile(src, des);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionClick(WebElement ele, String value) {
		action=new Actions(driver);
		switch(value)
		{
		case "double":
			action.doubleClick(ele).perform();;
		case "rightclick":
			action.contextClick(ele).perform();;
		}
	}
	@Override
	public void enterFrame(String value, int index, String frame) {
		switch((value).toLowerCase())
		{
		case "name":
			driver.switchTo().frame(frame);
			break;
		case "index":
			driver.switchTo().frame(index);
			break;
		}
	}
	@Override
	public void exitFrame(String value) {
		if(value.equals("parent")) {
			driver.switchTo().parentFrame();
		}
		else if(value.equals("default")){
			driver.switchTo().defaultContent();
		}}

	@Override
	public void moveTo(WebElement ele) {				
		action.moveToElement(ele).build().perform();		
		
	}
	@Override
	public void inputKeys(String value, WebElement ele) {		
		action.sendKeys(ele, value).build().perform();		
		
	}
	@Override
	public void dragDrop(WebElement src, WebElement target) {		
		action.dragAndDrop(src, target).perform();
	}
	@Override
	public String pageTitle() {

		String text = driver.getTitle();
		return text;
	}
	@Override
	public String pageUrl() {

		String text = driver.getCurrentUrl();
		return text;
	}
	@Override
	public String pageSource() {

		String pgSource = driver.getPageSource();
		return pgSource;
	}
	@Override
	public WebDriverWait waits() {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return Wait;
	}

//	@Override
//	public void get(String url) {
//		// TODO Auto-generated method stub
//		
//	}
	

}
