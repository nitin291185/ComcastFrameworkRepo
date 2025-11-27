package Practice_data_driven_testing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonFile {

	public static void main(String[] args) throws Throwable, IOException, ParseException {
	// Step1: Parse Json file into Java Object using JsonParse class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\commondata_json.json"));
		
		// Step2: convert  java object into json object using down casting
		JSONObject map=(JSONObject) obj;
		
		// Step3: get the value from jason using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("organisation"));
		

	}

}
