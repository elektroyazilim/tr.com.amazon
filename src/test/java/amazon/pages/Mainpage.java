package amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Mainpage extends Base{


    @FindBy(css = "a#nav-logo-sprites")
    public WebElement amazonLogoLink;

    @FindBy(css = "a#nav-orders")
    public WebElement orderLinkOnHeader;

    @FindBy(css ="input#sp-cc-accept")
    public WebElement acceptCookieBtn;

    @FindBy(css = "a#nav-link-accountList")
    public WebElement accountsLoginSectionOnHeader;

    @FindBy(css = "div#nav-flyout-accountList") //div#nav-al-container
    public WebElement loginPopupOnHeader;

    @FindBy(css = "div#nav-flyout-accountList a")
    public List<WebElement> loginPopupLinksOnHeader;

   @FindBy(xpath = "//span[text()='Giriş yap']/..")
    public WebElement girisYapBtnHomePage;

}
