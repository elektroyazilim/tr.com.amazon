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

    @Then("the user verifies if the Giris yap button exists on Homepage")
    public void theUserVerifiesIfTheGirisYapButtonExistsOnHomepage() {
        Assert.assertTrue(mainpage.girisYapBtnHomePage.isDisplayed());
        //System.out.println(mainpage.girisYapBtnHomePage.isDisplayed());

    }

    @When("the user clicks on the Giris yap button on Homepage")
    public void theUserClicksOnTheGirisYapButtonOnHomepage() {
        mainpage.girisYapBtnHomePage.click();
    }

    @When("the user clicks on Devam Et button on Login Page")
    public void theUserClicksOnDevamEtButtonOnLoginPage() {
        BrowserUtilities.waitForClickability(loginPage.devamEtBtn, 4);
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

        if (errorMsg.equals("Yanlış telefon numarası")) {
            BrowserUtilities.waitForVisibility(loginPage.upperAlertMessage2, 4);
            Assert.assertTrue(loginPage.upperAlertMessage2.getText().equals(errorMsg));
        } else {
            BrowserUtilities.waitForVisibility(loginPage.upperAlertMessage, 3);
            String errorMessage = loginPage.upperAlertMessage.getText().trim();
            //System.out.println(errorMsg.split(":")[1].trim());
            String actualMsg = errorMsg.split(":")[1].trim();
            //System.out.println(actualMsg);
            Assert.assertEquals(actualMsg, errorMessage);
        }
    }

    @When("the user types a valid {string} to the textbox")
    public void theUserTypesAValidEmailToTheTextbox(String email) {
        BrowserUtilities.clearTxtboxByJs(loginPage.emailPhoneTextbox);
        String validEmail = ConfigurationReader.getPropertyFromProperties(email);
        loginPage.emailPhoneTextbox.sendKeys(validEmail);
    }

    @Then("the user verifies if the {string} label exists")
    public void theUserVerifiesIfTheLabelExists(String text) {
        BrowserUtilities.waitForClickability(loginPage.girisYapBtn,3);
        Assert.assertEquals(text, loginPage.sifreLabel.getText().trim());
    }

    @When("the user types on textbox any invalid credential password")
    public void theUserTypesOnTextboxAnyInvalidCredentialPassword() {
        loginPage.passwordTxt.sendKeys("7128718278");
    }

    @And("the user clicks on the Giris Yap button on Login Page")
    public void theUserClicksOnTheGirisYapButtonOnLoginPage() {
        try {
            loginPage.girisYapBtn.click();
        }
        catch(Exception ex)
        {
            System.out.println("Hata : "+ex.getMessage());
        }
    }

    @When("the user types the textbox any numbers like {string}")
    public void theUserTypesTheTextboxAnyNumbersLike(String anyPhoneNumber) {

        loginPage.emailPhoneTextbox.sendKeys(anyPhoneNumber);
    }

    @When("the user types a valid phone number to the textbox")
    public void theUserTypesAValidPhoneNumberToTheTextbox() {
        BrowserUtilities.clearTxtboxByJs(loginPage.emailPhoneTextbox);
        loginPage.emailPhoneTextbox.sendKeys(ConfigurationReader.getPropertyFromProperties("phone"));
    }


    @When("the user types valid credential {string} to the {string} textbox")
    public void theUserTypesValidCredentialToTheTextbox(String data, String emailOrPswd) {


        if(emailOrPswd.equals("email"))
        {
            BrowserUtilities.waitForClickability(loginPage.devamEtBtn, 3);
            loginPage.emailPhoneTextbox.sendKeys(data);
        }
        else if(data.equals("password"))
        {
            BrowserUtilities.waitForClickability(loginPage.girisYapBtn, 3);
            String password = ConfigurationReader.getPropertyFromProperties(data);
            loginPage.passwordTxt.sendKeys(password);
        }
    }
}
