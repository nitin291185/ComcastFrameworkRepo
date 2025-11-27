package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToNewBrowser(WebDriver driver, String partial_url) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			@Nullable
			String act_url = driver.getCurrentUrl();
			if (act_url.contains(partial_url)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partial_title) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			@Nullable
			String act_title = driver.getTitle();
			if (act_title.contains(partial_title)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectByValue(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(text);
	}

	public void mouseMoveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public void refreshData(WebDriver driver) {

		driver.navigate().refresh();
	}

	public void ClickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void DragAndDrop(WebDriver driver, WebElement src, WebElement dstn) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dstn).perform();
	}

	public void ContextClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element);
	}

	public void Maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void Minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void SliderMovement(WebDriver driver, WebElement element, int x, int y) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).moveByOffset(x, y).release().perform();

	}

	public void resizeTheBrowser(WebDriver driver, int x, int y) {
		Dimension d = new Dimension(x, y);
		driver.manage().window().setSize(d);
	}

	public void dragABrowser(WebDriver driver, int x, int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(p);
	}

public void getScreenShot(WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File perm=new File("./TestData");
	FileHandler.copy(temp, perm);
	
		
}

}
