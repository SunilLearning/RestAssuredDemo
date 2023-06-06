package day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DiffrentWaysToPassPostRequestBody {

	// Master branch token id : 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
	
	//1. By using POJO Class
	//@Test(priority=1)
	public void createUser()
	{
		PojoClassRequestPayLoad data=new PojoClassRequestPayLoad();
		data.setName("sunil");
		data.setJob("Analyst");
		data.getJob();
		data.getName();
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all();
		
	}

	// By using HashMAp
	// By using org.json
	// by using external json file
}
