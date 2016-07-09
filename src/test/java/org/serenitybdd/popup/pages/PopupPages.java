package org.serenitybdd.popup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.google.com.vn/")
public class PopupPages extends PageObject {
	String defaultWindow = "";
	String subWindowHandler = null;

	private WebElement getWebElement(String element) {
		return getDriver().findElement(byElement(element));
	}

	private By byElement(String element) {
		By by = null;
		// startsWith: kiểm tra chuỗi bắt đầu bằng một chuỗi nào đó
		// substring: trả về một chuỗi con trong chuỗi ban đâu bắt đầu từ chỉ số
		try {
			if (element.startsWith("id=")) {
				element = element.substring(3);
				by = By.id(element);
			}
			if (element.startsWith("css=")) {
				element = element.substring(4);
				by = By.cssSelector(element);
			}
			return by;
		} catch (Exception e) {
		}
		;
		return null;

	}

	public void switchElement(String elementFrame) {
		try {
			WebElement webelement = getWebElement(elementFrame);
			getDriver().switchTo().frame(webelement);
		} catch (NoSuchFrameException e) {
			System.out.print(elementFrame);
		}
		;
	}

	public void ShowDialog(String elementDialog, String yourName) {
		getWebElement(elementDialog).click();
		getAlert().sendKeys(yourName);
		getAlert().accept();
	}

	public String getExpectText(String elementTextResult) {

		return getWebElement(elementTextResult).getText();
	}

	public void showDialogConfirm(String elementDialog) {
		getWebElement(elementDialog).click();
		getAlert().dismiss();
	}

	public void showDialogConfirmOk(String elementDialog) {
		getWebElement(elementDialog).click();
		getAlert().accept();
	}

	public String getExpectTextOnDialog(String elementDialog) {
		
		 getWebElement(elementDialog).click();
		 return getAlert().getText();
	}

}
