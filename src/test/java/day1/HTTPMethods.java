package day1;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

// token id master : 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
public class HTTPMethods {

	int id;

	@Test(priority = 1)
	public void geTListOfUsers() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	public void createUser() {
		HashMap data = new HashMap();
		data.put("name", "Sunil");
		data.put("job", "Engineer");
		

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

//	.then()
//	.statusCode(201)
//	.log().all();
	}

	@Test(priority = 3, dependsOnMethods = {"createUser"})
	public void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "Vishi");
		data.put("job", "Engineer Analyst");

		given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users" + id)

				.then().statusCode(201).log().all();
	}
	
	@Test(priority = 4, dependsOnMethods = {"updateUser"})
	public void deleteUser()
	{
		given()
		.contentType("application/json")
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204);
		
	}
}
