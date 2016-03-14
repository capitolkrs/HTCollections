package Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class BrowserProfile {
	private static WebDriver driver = null;

	public static void startWebDriver() {
		ProfilesIni profileInitializer = new ProfilesIni();
		FirefoxProfile profile = profileInitializer.getProfile("default");

		/*
		 * Setting the preference based on the key value pair from ****firefox
		 * browser :about.config ***
		 */
		profile.setPreference("browser.startup.homepage", "mail.goole.com"); // launch
																				// gmail
																				// on
																				// startup

		driver = new FirefoxDriver(profile);
		
		
		/*
		 * CHROME
		 */
		System.setProperty("webdriver.chrome.driver", "path to chrome driver");
		ChromeOptions option=new ChromeOptions();
		option.addEncodedExtensions("//");
		
		driver=new ChromeDriver(option);
		

	}

}
