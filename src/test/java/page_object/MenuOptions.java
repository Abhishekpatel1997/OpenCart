package page_object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuOptions extends BasePage {

	public MenuOptions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li") List<WebElement> menuOptions;
	
	public void sizeMenuOptions() {
		System.out.println("Number of menu options :"+ menuOptions.size());
	}
	
	public void printMenuOptions() {
		for(WebElement e: menuOptions) {
			System.out.println(e.getText());
		}
	}
	
	public List<String> actualMenuOptions(){
		List<String> optionsMenu=new ArrayList<>();
		for(WebElement n:menuOptions) {
			optionsMenu.add(n.getText().trim());
		}
		return optionsMenu;
	}

}
