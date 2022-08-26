package amazon.stepdefinitions.ui;

import amazon.pages.Mainpage;
import amazon.utilities.BrowserUtilities;
import amazon.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static amazon.stepdefinitions.ui.Hooks.driver;

public class US_001_Mainpage_SD {

    Mainpage mainpage = new Mainpage();

    @Given("the user navigates to {string}")
    public void theUserNavigatesTo(String url) {
        driver.get(ConfigurationReader.getPropertyFromProperties("environment") + url);
        System.out.println("1");
    }

    @Then("the user checks if the url contains {string}")
    public void theUserChecksIfTheUrlContains(String urlText) {
        Assert.assertTrue(driver.getCurrentUrl().contains(urlText));
        System.out.println("2");
    }

    @Then("the user checks if the logo link contains {string}")
    public void theUserChecksIfTheLogoLinkContains(String urlText) {
        String logoHref = mainpage.amazonLogoLink.getAttribute("href");
        Assert.assertTrue(logoHref.contains(urlText));
        System.out.println("3");
    }

    @Then("the user checks if Orders link is enable")
    public void theUserChecksIfOrdersLinkIsEnable() {
        mainpage.orderLinkOnHeader.isEnabled();
        System.out.println("4");
    }

    @When("the user accepts the cookie")
    public void theUserAcceptsTheCookie() {
        try {
            if(mainpage.acceptCookieBtn.isEnabled())
                mainpage.acceptCookieBtn.click();
        }
        catch(Exception ex)
        {
            System.out.println("tiklayamadi");
        }
    }

    @And("the the user hover Accounts section")
    public void theTheUserHoverAccountsSection() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainpage.accountsLoginSectionOnHeader).build().perform();
        System.out.println("5");
    }

    @Then("the user checks the if Sign in popup is open")
    public void theUserChecksTheIfSignInPopupIsOpen() {
        BrowserUtilities.waitForVisibility(mainpage.loginPopupOnHeader, 4);
        Assert.assertTrue(mainpage.loginPopupOnHeader.isDisplayed());
        System.out.println("6");
    }

    @Then("the user checks if links on the popup are enabled")
    public void theUserChecksIfLinksOnThePopupAreEnabled() {

        for (WebElement link : mainpage.loginPopupLinksOnHeader) {
            System.out.println(link.getText());
            Assert.assertTrue(link.isEnabled());
        }
        System.out.println("7");
    }
}
