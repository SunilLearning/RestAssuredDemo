package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CaptureCookiesValues {

	//@Test
	public void getCookieValue()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC", "AUEFqZc2Xw48i7V4u9L-Mh8mEAnocSVxl9ZwpW90Cj3IPmYnjJL86lGg3Q")
		.log().all();
		
	}
	
	// capture the cookies info
	
	@Test
	public void getCookiesInfo()
	{
		
		Response res=given()
		
		.when()
		.get("https://www.google.com/");
		// while capturing the whole infromation no need then method if we ends the statment then only we can able to capture the 
		//whole body response
		
		// capture the single cookie info
		//String cookie_value=res.getCookie("AEC");
		//System.out.println(cookie_value);
		
		// capture all cookie info, both key and value
		Map<String, String> cookie_values=res.getCookies();
		for(String k:cookie_values.keySet())
		{
			String cookie_value=res.getCookie(k);
			System.out.println(k +" : "+cookie_value);
		}
	}
}

