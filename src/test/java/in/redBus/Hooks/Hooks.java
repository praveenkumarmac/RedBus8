package in.redBus.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import in.redBus6.BaseClass.BaseClass;
import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	BaseClass base = new BaseClass();
	
	@Before
	public void launchBrowser() {
		base.browserLaunch();
//		final byte[] source = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
//		scenario.embed(source,"image/png");
		
	}
	
	@After
	public void closeBrowser() {
		base.browserClose();
//		final byte[] source = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
//		//scenario.embed(source,"image/png");
		
	}
	

}
