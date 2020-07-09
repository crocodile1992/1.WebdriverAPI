package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class VerifyGuruWebDemo {

	WebDriver driver;

	/*
	 * 1.Mở trình duyệt Chrome 2.Truy cập vào trạng http://live.guru99.com/
	 * 3.Kiểm tra link url trang có phải là http://live.guru99.com/ 4.Kiểm tra
	 * tiêu đề trang có đúng là "Home Page" 5.Đóng trình duyệt
	 */
	@BeforeClass
	public void beforeClass() {
		// Thiết lập thông tin đường dẫn tới file chrome driver
		System.setProperty("webdriver.chrome.driver",
				"D:\\data\\autotest\\workspace\\1.WebDriverAPI\\CheckEnviromentAfterInstal\\driver\\chromedriver.exe");
		// 1.Mở trình duyệt Chrome
		driver = new ChromeDriver();
		// 2.Truy cập vào trạng http://live.guru99.com/
		driver.get("http://live.guru99.com/");
		// Thiết lập giá trị timeout sau khi mở trình duyệt
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_VerifyUrlHomePage() {
		String urlHomePage = driver.getCurrentUrl();
		System.out.println("Url Page Home: " + urlHomePage);
		Assert.assertEquals(urlHomePage, "http://live.demoguru99.com/");
	}

	@Test
	public void TC_02_VerifyTitleHomePage() {
		String titleHomePage = driver.getTitle();
		System.out.println("Title Page Home: " + titleHomePage);
		Assert.assertEquals(titleHomePage, "Home page");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
