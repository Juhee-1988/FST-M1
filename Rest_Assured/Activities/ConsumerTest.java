package liveProject;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.core.model.RequestResponsePact;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	
	// Set the headers
	Map<String, String> headers = new HashMap<String, String>();
	
	// Create the Contract(Pact)
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		
		//Set the headers
		headers.put("Content-Type","application/json");
		
		//Create the request and response body
		DslPart requestResponseBody = new PactDslJsonBody().
			 numberType("id",331).
			 stringType("firstName","Juhee").
			 stringType("lastName","Jameela").
			 stringType("email","juhee@example.com");
		
		//Create the contract
		return builder.given("POST Request").
			uponReceiving("request to create user").
				method("POST").
				path("/api/users").
				headers(headers).
				body(requestResponseBody).
			willRespondWith().
				status(201).
				body(requestResponseBody).
			toPact();		
	}
	
	//Consumer test with mock provider
	@Test
	@PactTestFor(providerName = "UserProvider", port = "8787")
	public void postRequestTest() {
		
		//Create a request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id",331);
		reqBody.put("firstName","Juhee");
		reqBody.put("lastName","Jameela");
		reqBody.put("email","juhee@example.com");
		
		//Send a request, get response, assert response
		given().baseUri("http://localhost:8787/api/users").headers(headers).body(reqBody).log().all().
		when().post().
		then().statusCode(201).body("id", equalTo(331)).log().all();	
	}	

}
