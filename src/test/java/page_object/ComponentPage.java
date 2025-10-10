package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ComponentPage extends BasePage {

	public ComponentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Components']") WebElement componentMenu;
	@FindBy(xpath="//a[normalize-space()='Monitors (2)']") WebElement btnMonitor;
	@FindBy(xpath="//h2[normalize-space()='Monitors']") WebElement cnfMonitorMessage;
	
	public void hoverAndClickSubmenu() {
	    Actions actions = new Actions(driver);
	    actions.moveToElement(componentMenu).perform();
	    actions.click(btnMonitor).perform();
	    
	}
	
	public String cnfMonMsg() {
		return(cnfMonitorMessage.getText());
	}
	
	
	

	
}
