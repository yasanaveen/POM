package com.OHRMLoginPageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_Objects {

	public WebDriver driver;

	public HomePage_Objects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private @FindBy(xpath = "//*[@class='oxd-main-menu']//li[2]//a") WebElement btn_pim;
	private @FindBy(xpath = "(//button[@type='button'])[5]") WebElement btn_add;

	private @FindBy(name = "firstName") WebElement addEmp_firstName;
	private @FindBy(name = "lastName") WebElement addEmp_lastname;
	private @FindBy(xpath = "//*[text()=' Save ']") WebElement addEmp_btnSave;

	// click on logout
	private @FindBy(xpath = "//*[@class='oxd-userdropdown-tab']") WebElement btn_logout;
	private @FindBy(xpath = "//*[text()='Logout']") WebElement clk_logout;

	
	public void clcikOn_pimBtn() {
		btn_pim.click();
	}

	public void btn_add() {
		btn_add.click();
	}

	public void enterdetails(String fname, String lName) throws InterruptedException {
		addEmp_firstName.sendKeys(fname);
		addEmp_lastname.sendKeys(lName);
		Thread.sleep(3000);
		addEmp_btnSave.click();
		Thread.sleep(3000);
	}

	public void clickLogout() throws InterruptedException {
		btn_logout.click();
		Thread.sleep(3000);

		clk_logout.click();
	}
}
