package testRunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.Login_page;
import setUp.Set_up;

import java.io.IOException;

import static utils.Utils.readJsonDAta;

public class UserLoginTestRunner extends Set_up {

    @Test()
    public void userLogin() throws IOException, ParseException {
        Login_page loginPage=new Login_page(driver);
        JSONArray jsonArray= readJsonDAta();
        JSONObject jsonObject=(JSONObject) jsonArray.get(jsonArray.size()-1);
        String username=jsonObject.get("username").toString();
        String password=jsonObject.get("password").toString();
        loginPage.do_login(username,password);
    }

}
