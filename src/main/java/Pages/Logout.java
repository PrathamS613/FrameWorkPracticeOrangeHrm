package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonMethods;

public class Logout extends CommonMethods {

	@FindBy(xpath = "//a[@href='/web/index.php/dashboard/index']")
	WebElement Dashboard;

	@FindBy(xpath = "//img[contains(@class,'oxd-userdropdown-img')]")
	WebElement ClickonUser;

	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logoutbuttin; 

	public Logout(WebDriver driver, int waittime) {
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		PageFactory.initElements(driver, this);
	}

	public void logoutApplication() {
		click(Dashboard, " Dashboard");

		click(ClickonUser, " UserIcon");

		click(logoutbuttin, " Logout button");
		
		System.out.println("Logout Sucessfull!!");

	}
}
