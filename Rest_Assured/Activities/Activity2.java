package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {
	
	final static String URI = "https://petstore.swagger.io/v2/user";
	
	@Test(priority=1)
	public void createUser() throws IOException{
		
		FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userinfo.json");
		
		String reqBody = new String(inputJSON.readAllBytes());

		Response response =	
				given().contentType("application/json").body(reqBody).
				when().post(URI);
		
		inputJSON.close();
				
		response.then().body("code", equalTo(200)).body("message", equalTo("1988")).log().all();
	}
	
	
	@Test(priority=2)
	public void getUser() {
		
		File outputJSON = new File("src/test/java/activities/getUserResponse.json");
		
		Response response =
			given().contentType("application/json").
			pathParam("username","jami").
			when().get(URI + "/{username}");
		
		String resBody = response.getBody().asPrettyString();
		
		try {
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
			
		response.then().body("id", equalTo(1988));
		response.then().body("username", equalTo("jami"));
		response.then().body("firstName", equalTo("Juhee"));
		response.then().body("lastName", equalTo("Jameela"));
		response.then().body("email", equalTo("juheejameela@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9878612345"));
		
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		
		Response response =
				given().contentType("application/json").
				pathParam("username","jami").
				when().delete(URI + "/{username}");
		
		response.then().body("code", equalTo(200)).body("message", equalTo("jami")).log().all();

}
	
}
