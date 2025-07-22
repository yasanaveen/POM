package com.OHRMLoginPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OHRM_LogiPage {

	public WebDriver driver;

	public OHRM_LogiPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@name='username']") WebElement txt_username;
	private @FindBy(name = "password") WebElement txt_password;
	private @FindBy(xpath = "//button[text()=' Login ']") WebElement btn_login;

	// click on logout
	private @FindBy(xpath = "//*[@class='oxd-userdropdown-tab']") WebElement btn_logout;
	private @FindBy(xpath = "//*[text()='Logout']") WebElement clk_logout;

	private @FindBy(xpath = "//*[@class='oxd-navbar-nav']//img[@alt='client brand banner']") WebElement validating_logo;

	public void setUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void setPassword(String pwd) throws InterruptedException {
		txt_password.sendKeys(pwd);

		btn_login.click();
	}

	public boolean logoValidation() {
		return validating_logo.isDisplayed();

	}

	public void clickLogout() throws InterruptedException {
		btn_logout.click();

		Thread.sleep(3000);

		clk_logout.click();
	}

}
