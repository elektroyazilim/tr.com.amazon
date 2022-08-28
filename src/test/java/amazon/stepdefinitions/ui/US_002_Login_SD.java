package amazon.stepdefinitions.ui;

import amazon.pages.LoginPage;
import amazon.pages.Mainpage;
import amazon.utilities.BrowserUtilities;
import amazon.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_002_Login_SD {

    Mainpage mainpage = new Mainpage();
    LoginPage loginPage = new LoginPage();
    @Then("the user verifies if the Giriş yap button exists on Homepage")
    public void theUserVerifiesIfTheGirişYapButtonExistsOnHomepage() {
        Assert.assertTrue(mainpage.girisYapBtnHomePage.isDisplayed());
        //System.out.println(mainpage.girisYapBtnHomePage.isDisplayed());

    }

    @When("the user clicks on the Giriş yap button on Homepage")
    public void theUserClicksOnTheGirişYapButtonOnHomepage() {
        mainpage.girisYapBtnHomePage.click();
    }

    @When("the user clicks on Devam Et button on Login Page")
    public void theUserClicksOnDevamEtButtonOnLoginPage() {
        BrowserUtilities.waitForClickability(loginPage.devamEtBtn,4);
        loginPage.devamEtBtn.click();
    }

    @Then("the user verifies if {string} message appears")
    public void theUserVerifiesIfMessageAppears(String message) {
        //System.out.println(loginPage.miniAlertMessage.getText());
        Assert.assertTrue(message.equals(loginPage.miniAlertMessage.getText()));
    }

    @When("the user types alphanumeric inputs like {string} to the email textbox")
    public void theUserTypesAlphanumericInputsLikeToTheEmailTextbox(String invalidEmail) {
        loginPage.emailPhoneTextbox.sendKeys(invalidEmail);
    }

    @Then("the user verifies if the {string} error box appears")
    public void theUserVerifiesIfTheErrorBoxAppears(String errorMsg) {

        BrowserUtilities.waitForVisibility(loginPage.upperAlertMessage,3);
        String errorMessage = loginPage.upperAlertMessage.getText().trim();
        //System.out.println(errorMsg.split(":")[1].trim());
        String actualMsg = errorMsg.split(":")[1].trim();
        //System.out.println(actualMsg);
        Assert.assertEquals(actualMsg,errorMessage);

    }

    @When("the user types a valid {string} to the textbox")
    public void theUserTypesAValidEmailToTheTextbox(String email) {
        BrowserUtilities.clearTxtboxByJs(loginPage.emailPhoneTextbox);
        String validEmail = ConfigurationReader.getPropertyFromProperties(email);
        loginPage.emailPhoneTextbox.sendKeys(validEmail);
    }

    @Then("the user verifies if the {string} label exists")
    public void theUserVerifiesIfTheLabelExists(String text) {
        Assert.assertEquals(text, loginPage.sifreLabel.getText().trim());
    }

    @When("the user types on textbox any invalid credential password")
    public void theUserTypesOnTextboxAnyInvalidCredentialPassword() {
        loginPage.passwordTxt.sendKeys("7128718278");
    }

    @And("the user clicks on the Giris Yap button on Login Page")
    public void theUserClicksOnTheGirisYapButtonOnLoginPage() {
        loginPage.girisYapBtn.click();
    }

    @When("the user types the textbox any numbers like {string}")
    public void theUserTypesTheTextboxAnyNumbersLike(String errorMsg) {

    }

    @When("the user types a valid phone number to the textbox")
    public void theUserTypesAValidPhoneNumberToTheTextbox() {
    }

    @When("the user clicks on Giriş yap button on Login page")
    public void theUserClicksOnGirişYapButtonOnLoginPage() {
    }

    @When("the user types valid credential {string} to the {string} textbox")
    public void theUserTypesValidCredentialToTheTextbox(String arg0, String arg1) {
    }

    @And("the user clicks on Devam Et button")
    public void theUserClicksOnDevamEtButton() {
    }


}
