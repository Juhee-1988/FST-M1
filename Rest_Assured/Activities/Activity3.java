package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	
	//POST https://petstore.swagger.io/v2/pet
	
 	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;
	
	@BeforeClass
	public void setup() {
		
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type", "application/json").
				build();
		responseSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType("application/json").
				expectBody("status", equalTo("alive")).
				build();			
	}
	
	@DataProvider
	public Object[][] petInfoProvider(){
		Object[][] testData = new Object[][] {
			{66535,"Simba","alive"},
			{66536,"Ginger","alive"}
		};
		return testData;
		}	
	
	@Test(priority = 1)
	public void postRequest() {
		
		String reqBody = "{\"id\": 66535,\"name\": \"Simba\",\"status\": \"alive\"}";
		
		Response response =	given().spec(requestSpec).body(reqBody).when().post();
		
		reqBody = "{\"id\": 66536,\"name\": \"Ginger\",\"status\": \"alive\"}";
		
		response =	given().spec(requestSpec).body(reqBody).when().post();
		
		response.then().spec(responseSpec);
	}
	
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	
	@Test(dataProvider = "petInfoProvider",priority = 2)
	public void getRequest(int id, String name, String status) {
		
		Response response = given().spec(requestSpec).pathParam("petId", id).when().get("/{petId}");
		
		System.out.println(response.getBody().asPrettyString());
		
		response.then().spec(responseSpec).body("name",equalTo(name));		
		
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	
	@Test(dataProvider = "petInfoProvider",priority = 3)
	public void deleteRequest(int id, String name, String status) {
		
		given().spec(requestSpec).pathParam("petId", id).
		when().delete("/{petId}").
		then().statusCode(200).body("message",equalTo(""+id));
		
	}

}
