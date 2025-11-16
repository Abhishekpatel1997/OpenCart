package page_object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentDropDown extends BasePage{

	public ComponentDropDown(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//li[@class='dropdown']//a[text()='Components']") WebElement btnComponent;
	@FindBy(xpath="//li[@class='dropdown open']//div[@class='dropdown-inner']//ul[@class='list-unstyled']/li") List<WebElement> componentDropDownOption;
    @FindBy(xpath="//a[normalize-space()='Monitors (2)']") WebElement btnMonitor;
    @FindBy(xpath="//div[@id='content']//h2[text()='Monitors']") WebElement txtValidationMsg;
    
    public void clickOnComponent() {

    	btnComponent.click();    }
    public void sizeOfMonitorDropDown() {
    	System.out.println("Number od drop-down options in component drop-down :"+ componentDropDownOption.size());
    }
    
    public void printComponentDropDownOption() {
    	System.out.println("DropDown options are:");
    	for(WebElement k:componentDropDownOption) {
    		System.out.println(k.getText());
    	}
    }
    
    public void clickOnMonitor() {
    	for(WebElement k:componentDropDownOption) {
    		if(k.getText().contains("Monitors (2)")) {
    			k.click();
    			break;
    		}
    	}
    }
    
    public String getValidationMsg() {
    	String s= txtValidationMsg.getText().trim();
    	return s;
    }
    
	
	
}
