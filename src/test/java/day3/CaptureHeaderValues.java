package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CaptureHeaderValues {

	@Test()
	public void getHeadersInfo()
	{
		Response res=given()
		
		.when()
		.get("https://www.google.com/");
		
		// capyure single header value
		String headerValue=res.getHeader("Content-Type");
		System.out.println(headerValue);
		
		//capture all header values
		Headers headerValues=res.getHeaders();
		for(Header h: headerValues)
		{
			String headerName=h.getName();
			String headerValue1=h.getValue();
			System.out.println(headerName+" : "+headerValue1);
		}
	}
	
}
