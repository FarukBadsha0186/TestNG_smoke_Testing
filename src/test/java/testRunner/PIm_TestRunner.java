package testRunner;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login_page;
import pages.PIMPage;
import setUp.EmployeeMOdel;
import setUp.Set_up;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class PIm_TestRunner extends Set_up {

    PIMPage pimPage;
    Login_page loginPage;

    @BeforeTest(groups = "smoke")
    public void do_login(){
        loginPage=new Login_page(driver);
        loginPage.do_login("Admin","admin123");
    }

    @Test(priority = 1)
    public void checkEmplyoeeList() throws InterruptedException {
        pimPage=new PIMPage(driver);
        pimPage.leftMenuBar.get(1).click();
        Thread.sleep(5000);
        String messageActual= driver.findElements(By.className("oxd-text--span")).get(12).getText();
        String messageExpected="Records Found";
        Assert.assertTrue(messageActual.contains(messageExpected));

    }

    @Test (priority = 2)
    public void addNewEmployee() throws InterruptedException, IOException, ParseException {
        pimPage.button.get(2).click();
        Thread.sleep(5000);
        driver.findElement(By.className("oxd-switch-input")).click();
        pimPage= new PIMPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String userName=faker.name().username();
        String password="password123";
        EmployeeMOdel employeeMOdel=new EmployeeMOdel();
        employeeMOdel.setFirstName(firstName);
        employeeMOdel.setLastName(lastName);
        employeeMOdel.setUsername(userName);
        employeeMOdel.setPassword(password);
        pimPage.addNewEmployee(employeeMOdel);
        WebElement headerElementTittle=driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));
        WebDriverWait wait=new WebDriverWait( driver, Duration.ofSeconds(50 ));
        wait.until(ExpectedConditions.visibilityOf(headerElementTittle));
        String textTittle=headerElementTittle.getText();
        Assert.assertTrue(textTittle.contains("Personal Details"));

      //  Utils.saveUser(firstName,lastName,userName,password);
        Utils.saveUser(firstName,lastName,userName,password);








    }

}
