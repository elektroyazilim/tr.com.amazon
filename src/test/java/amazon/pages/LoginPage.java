package amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base{
    @FindBy(css = "input#continue")
    public WebElement devamEtBtn;

    // sibling by css
    @FindBy(css = "input[name='password']+div div.a-alert-content")
    public WebElement miniAlertMessage; //under the textbox

    @FindBy(css = "input[name='email']")
    public WebElement emailPhoneTextbox;

    // Bir Sorun Oluştu message alert
    @FindBy(css = "div.a-alert-content span")
    public WebElement upperAlertMessage;

    @FindBy(css = "h4.a-alert-heading")
    public WebElement upperAlertMessage2;

    @FindBy(xpath = "//label[contains(text(),'Şifre')]")
    public WebElement sifreLabel;

    @FindBy(css = "input[name='password']")
    public WebElement passwordTxt;

    @FindBy(css = "input#signInSubmit")
    public WebElement girisYapBtn;


}
