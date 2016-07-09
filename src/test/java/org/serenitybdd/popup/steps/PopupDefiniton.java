package org.serenitybdd.popup.steps;

import org.serenitybdd.popup.steps.serenity.PopupSteps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PopupDefiniton {
	@Steps
	PopupSteps popup;

	@Given("^the page \"([^\"]*)\" is visited$")
	public void the_page_is_visited(String linkVisited) throws Throwable {
		popup.openLinkVisited(linkVisited);
	}

	@Given("^go inside the \"([^\"]*)\" frame$")
	public void go_inside_the_frame(String elementFrame) throws Throwable {
		popup.switchtoFrame(elementFrame);
	}

	@Given("^input \"([^\"]*)\" on prompt dialog box \"([^\"]*)\"$")
	public void input_on_prompt_dialog_box(String yourName, String elementDialog)
			throws Throwable {
		popup.showDialog(elementDialog, yourName);
	}

	@Then("^assert that the text \"([^\"]*)\" element is \"([^\"]*)\"$")
	public void assert_that_the_text_element_is(String elementTextResult,
			String TextResult) throws Throwable {
		popup.assertTextResult(elementTextResult, TextResult);
	}

	@Given("^choose CANCEL on confirm dialog box \"([^\"]*)\"$")
	public void choose_CANCEL_on_confirm_dialog_box(String elementDialog)
			throws Throwable {
		popup.cancelDialog(elementDialog);

	}

	@Given("^choose OK on confirm dialog box \"([^\"]*)\"$")
	public void choose_OK_on_confirm_dialog_box(String elementDialog)
			throws Throwable {
		popup.okDialog(elementDialog);
	}

	@Then("^assert that text on \"([^\"]*)\" popup box is \"([^\"]*)\"$")
	public void assert_that_text_on_popup_box_is(String elementDialog,
			String textOnDialog) throws Throwable {
		popup.assertTextOnDialog(elementDialog, textOnDialog);
	}
}
