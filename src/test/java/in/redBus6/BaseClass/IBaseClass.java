package in.redBus6.BaseClass;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface IBaseClass {
	
	void browserLaunch ();
	void browserClose ();
	void inputKeys (WebElement ele, String value);
	void button (WebElement ele);
	boolean displayed (WebElement ele);
	boolean selected (WebElement ele);
	boolean enabled (WebElement ele);
	void moveForward ();
	void moveBackward (); 
	String returnText (WebElement ele);
	String returnAttribute (WebElement ele, String attribute);
	String returnCssValue (WebElement ele, String cssName);
	void valueSelect (WebElement ele, String value);
	void indexSelect (WebElement ele, int i);
	List<WebElement> returnOptions(WebElement ele);
	void parentWindow();
	void childWindow();
	void inputkeys(Alert a, String value);
	void screenshot(String imageName);
	void actionClick(WebElement ele, String value);
	void enterFrame(String value, int i, String frame);
	void exitFrame(String value);
	void moveTo(WebElement ele);
	void inputKeys(String valuem, WebElement ele);
	void dragDrop(WebElement src, WebElement tar);
	String pageTitle();
	String pageUrl();
	String pageSource();
	WebDriverWait waits();
	//void get(String url);
	void launchApplication(String url);

}
