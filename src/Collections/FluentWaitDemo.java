package Collections;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;

public class FluentWaitDemo {
	
	private WebDriver driver;
	
	public void waitingFluent(){
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(5, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		
		
		Predicate<WebElement> t=new Predicate<WebElement>() {

			@Override
			public boolean apply(WebElement arg0) {
			
				if(arg0.getText().equalsIgnoreCase("myText")){
					System.out.println("Element found");
					return true;
				} else{
					System.out.println("Element not found continue pooling");
					return false;
				}
				
				
			}
		};
		
		wait.until(t);//pull until the value is true
	
	}
	
	

}
