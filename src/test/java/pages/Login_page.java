package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login_page {
    @FindBy(name ="username")
    WebElement textUsername;
    @FindBy(name = "password")
    WebElement textPassword;
    @FindBy(css ="[type=submit]")
    WebElement btn_Submit;

    @FindBy(className= "oxd-userdropdown-img")
    public   WebElement btn_ProfileImage;

    @FindBy(css = "[role=menuitem]")
    List<WebElement> dropdownMenu;

    public  Login_page (WebDriver driver){
        PageFactory.initElements( driver, this);

    }

    public void login_with_WrongPassword( String username, String password){
        textUsername.sendKeys(username);
        textPassword.sendKeys(password);
        btn_Submit.click();

    }


    public void  do_login( String username, String password){
        textUsername.sendKeys(username);
        textPassword.sendKeys(password);
        btn_Submit.click();

    }

    public void do_logout(){
        btn_ProfileImage.click();
        dropdownMenu.get(3).click();
    }
}
