package testRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_page;
import setUp.Set_up;

public class Login_TestRunner extends Set_up {
    Login_page loginPage;


    @Test (priority = 1, groups = "smoke")
    public void login_with_WrongPassword(){
        loginPage=new Login_page(driver);
        loginPage.login_with_WrongPassword("Admin","admin12345");
        //  Assert.assertTrue(loginPage.btn_ProfileImage.isDisplayed());

    }

    @Test (priority = 2 , groups =  "smoke")
    public void do_login(){
        loginPage=new Login_page(driver);
       // loginPage.do_login("Admin","admin123");
        loginPage.do_login(System.getProperty("username"),System.getProperty("password"));
        Assert.assertTrue(loginPage.btn_ProfileImage.isDisplayed());


    }
    @Test (priority = 3 ,groups = "smoke")
    public void do_logout(){
        loginPage=new Login_page(driver);
        loginPage.do_logout();
        WebElement forgetPassword=driver.findElement(By.className("orangehrm-login-forgot-header"));
        Assert.assertTrue(forgetPassword.isDisplayed());
    }
}
