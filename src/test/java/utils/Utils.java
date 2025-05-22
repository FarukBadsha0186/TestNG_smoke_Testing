package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void saveUser(String firstName ,String lastName, String username,String password) throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser parser=new JSONParser();
        JSONArray empArray=(JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject empObject=new JSONObject();
        empObject.put("firstName",firstName);
        empObject.put("lastName",lastName);
        empObject.put("username",username);
        empObject.put("password",password);

        empArray.add(empObject);
        FileWriter writer=new FileWriter(fileLocation);
        writer.write(empArray.toJSONString());
        writer.flush();
        writer.close();
    }
    public static JSONArray readJsonDAta() throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser parser=new JSONParser();
        JSONArray empArray=(JSONArray) parser.parse(new FileReader(fileLocation));
        return empArray;
    }

    public static void main(String[] args) throws IOException, ParseException {



    }

}
