package amazon.pages;

import amazon.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class Base {
    public Base() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
