package org.serenitybdd.popup.steps.serenity;

import org.junit.Assert;
import org.serenitybdd.popup.pages.PopupPages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PopupSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PopupPages popuppage;

	@Step
	public void openLinkVisited(String linkVisited) {
		popuppage.open();
		popuppage.openAt(linkVisited);
		popuppage.getDriver().manage().window().maximize();
	}

	@Step
	public void switchtoFrame(String elementFrame) {
		popuppage.switchElement(elementFrame);
	}

	@Step
	public void showDialog(String elementDialog, String yourName) {
		popuppage.ShowDialog(elementDialog, yourName);
	}

	@Step
	public void assertTextResult(String elementTextResult, String textResult) {
		Assert.assertEquals(popuppage.getExpectText(elementTextResult),
				textResult);
	}
@Step
	public void cancelDialog(String elementDialog) {
	popuppage.showDialogConfirm(elementDialog);
	}
@Step
public void okDialog(String elementDialog) {
	popuppage.showDialogConfirmOk(elementDialog);
}
@Step
public void assertTextOnDialog(String elementDialog, String textOnDialog) {
	Assert.assertEquals(popuppage.getExpectTextOnDialog(elementDialog),
			textOnDialog);
}
}
