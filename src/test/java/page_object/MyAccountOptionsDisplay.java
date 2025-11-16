package page_object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountOptionsDisplay extends BasePage{

	public MyAccountOptionsDisplay(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="(//div[@id='content']//ul[@class='list-unstyled'])[1]//a") List<WebElement> linkOfOptions;
	
	public void sizeOfOptions() {
		System.out.println("Number of options:"+ linkOfOptions.size());
	}
	public void optionPrint() {
		
		System.out.println("Window Options :");
		for(WebElement li:linkOfOptions) {
			System.out.println(li.getText());
		}
	}
	
	public List<String> actualOptions(){
		List<String> optionsList=new ArrayList<>();
		for(WebElement w: linkOfOptions) {
			optionsList.add(w.getText().trim());
		}
		return optionsList;
	}

}
