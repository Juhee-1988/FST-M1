package activities;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class Activity1 {
	
	@Test
	public void createPet() {
		
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id",15724);
		reqBody.put("name","Simba");
		reqBody.put("status","alive");
		Response response =	
				given().
				baseUri("https://petstore.swagger.io/v2/pet").
				contentType("application/json").
				body(reqBody).when().post();
		
		response.then().statusCode(200).body("name", equalTo("Simba")).body("status", equalTo("alive"));
		
	}
	
	@Test(dependsOnMethods = {"createPet"})
	public void getPet() {
		
		Response response =
			given().
				baseUri("https://petstore.swagger.io/v2/pet").
				header("Content-Type","application/json").
				pathParam("petId",15724).
			when().
				get("/{petId}");
		
		response.then().statusCode(200).body("name", equalTo("Simba")).body("status", equalTo("alive"));
		
	}
	
	@Test(dependsOnMethods = {"getPet"})
	public void deletePet() {
		
		Response response =
				given().
					baseUri("https://petstore.swagger.io/v2/pet").
					header("Content-Type","application/json").
					pathParam("petId",15724).
				when().delete("/{petId}");
		
		response.then().body("code", equalTo(200)).body("message", equalTo("15724"));
	}

}
