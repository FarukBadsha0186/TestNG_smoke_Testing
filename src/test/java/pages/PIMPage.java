package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setUp.EmployeeMOdel;

import java.util.List;

public class PIMPage {
    WebDriver driver;
    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> leftMenuBar;

    @FindBy(className = "oxd-button")
    public List<WebElement> button;

    @FindBy(className = "oxd-input")
    public List<WebElement> textField;

    public PIMPage( WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void addNewEmployee(EmployeeMOdel mOdel){

        textField.get(1).sendKeys(mOdel.getFirstName());
        textField.get(3).sendKeys(mOdel.getLastName());
        textField.get(5).sendKeys(mOdel.getUsername());
        textField.get(6).sendKeys(mOdel.getPassword());
        textField.get(7).sendKeys(mOdel.getPassword());
        button.get(1).click();

    }
}
