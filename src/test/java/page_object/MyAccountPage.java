package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement MyAccountmessage;
	@FindBy(xpath="//input[@placeholder='Search']") WebElement search;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement btnsearch;
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']") WebElement cnfSearch;
	
	
	
	public boolean MyAccDisplay() {
		return (MyAccountmessage.isDisplayed());
	}
	
	public void SearchItem(String item) {
		search.sendKeys(item);
	}
	
	public void Searchbtn() {
		btnsearch.click();
	}
	

	public boolean GetProduct() {
		// TODO Auto-generated method stub
		return cnfSearch.isDisplayed();
	}

	

}
